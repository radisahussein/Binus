import sys
from time import sleep
import pygame
from bullet import Bullet
from alien import Alien

def check_keydown_events(event,ai_settings,screen,ship,bullets):
    #respond to key presses
    if event.key == pygame.K_RIGHT:
        #Move ship to the right
        ship.moving_right = True
    
    elif event.key == pygame.K_LEFT:
        #move ship left
        ship.moving_left = True
    
    elif event.key == pygame.K_SPACE:
        fire_bullet(ai_settings,screen,ship,bullets)
 
    elif event.key == pygame.K_q:
        sys.exit()

def check_keyup_events(event,ship):
    if event.key == pygame.K_RIGHT:
        ship.moving_right = False

    elif event.key == pygame.K_LEFT:
        ship.moving_left = False

def  check_events(ai_settings,screen,stats,sb,play_button,ship,aliens,bullets):
    #respond to keypresses and mouse events.
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            sys.exit()

        elif event.type == pygame.MOUSEBUTTONDOWN:
            mouse_x,mouse_y = pygame.mouse.get_pos()
            check_play_button(ai_settings,screen,stats,sb,play_button,ship,aliens,bullets,mouse_x,mouse_y)

        elif event.type == pygame.KEYDOWN:
            check_keydown_events(event,ai_settings,screen,ship,bullets)

        elif event.type == pygame.KEYUP:
            check_keyup_events(event,ship)

def check_play_button(ai_settings,screen,stats,sb,play_button,ship,aliens,bullets,mouse_x,mouse_y):
    #starts new game wen player clicks play

    button_clicked = play_button.rect.collidepoint(mouse_x,mouse_y)
    if button_clicked and not stats.game_active:

        #reset game settings
        ai_settings.initialize_dynamic_settings()

        #hide mouse cursor
        pygame.mouse.set_visible(False)

        stats.reset_stats()
        stats.game_active = True

        #reset scoreboard images
        sb.prep_score()
        sb.prep_high_score()
        sb.prep_level()
        sb.prep_ships()

        #empty list of aliens and bullets
        aliens.empty()
        bullets.empty()

        #create new fleet and center sip
        create_fleet(ai_settings,screen,ship,aliens)
        ship.center_ship

def update_screen(ai_settings, screen, stats,sb,ship, aliens, bullets,play_button):
    #update images on screen and flip to new screen
    screen.fill(ai_settings.bg_color)

    #redraw all bullets behind ship and aliens
    for bullets in bullets.sprites():
        bullets.draw_bullet()


    ship.blitme()
    aliens.draw(screen)

    #draw score info
    sb.show_score()

    #draw play button if game is inactive
    if not stats.game_active:
        play_button.draw_button()

    #make most recetnly drawn screen visible
    pygame.display.flip()

def update_bullets(ai_settings,screen,stats,sb,ship,aliens,bullets):
    #update bullets
    bullets.update()

    #deleting old bullets
    for bullet in bullets.copy():
        if bullet.rect.bottom <= 0:
            bullets.remove(bullet)
    
    check_bullet_alien_collisions(ai_settings,screen,stats,sb,ship,aliens,bullets)

def check_bullet_alien_collisions(ai_settings,screen,stats,sb,ship,aliens,bullets):
    #check if bullets hit aliens
    #get rid of bullets and aliens
    collisions = pygame.sprite.groupcollide(bullets,aliens,True,True)
    #change first true to false to make bullets pass through aliens, aliens removed, bullets not
    if collisions:
        for aliens in collisions.values():
            stats.score += ai_settings.alien_points * len(aliens)
            sb.prep_score()
        check_high_score(stats,sb)

    if len(aliens) == 0:
        #if entire fleet is destroyed start new level
        #destroy exisitng bullets,speed up game, and create new fleet
        bullets.empty()
        ai_settings.increase_speed()

        #increase level
        stats.level += 1
        sb.prep_level()

        create_fleet(ai_settings,screen,ship,aliens)

def fire_bullet(ai_settings,screen,ship,bullets):
    #fire bullet if limit not reached

    if len(bullets) < ai_settings.bullets_allowed:
        new_bullet = Bullet(ai_settings,screen,ship)
        bullets.add(new_bullet)
    
def get_number_aliens_x(ai_settings,alien_width):
    #determine number of aliens that fit in a row
    available_space_x = ai_settings.screen_width - 2 * alien_width
    number_aliens_x = int(available_space_x / (2 * alien_width))
    return number_aliens_x

def get_number_rows(ai_settings,ship_height,alien_height):
    #determine number of rows of aliens that fit on screen
    available_space_y = (ai_settings.screen_height - (3 * alien_height) - ship_height)
    number_rows = int(available_space_y / (2 * alien_height))
    return number_rows

def create_alien(ai_settings,screen,aliens,alien_number,row_number):
    #create alien and place in row
    alien = Alien(ai_settings,screen)
    alien_width = alien.rect.width
    alien.x = alien_width + 2 * alien_width * alien_number
    alien.rect.x = alien.x
    alien.rect.y = alien.rect.height + 2 * alien.rect.height * row_number
    aliens.add(alien)

def create_fleet(ai_settings,screen,ship,aliens):
    #create full fleet of aliens
    alien = Alien(ai_settings,screen)
    number_aliens_x = get_number_aliens_x(ai_settings,alien.rect.width)
    number_rows = get_number_rows(ai_settings,ship.rect.height,alien.rect.height)

    for row_number in range(number_rows):
        for alien_number in range(number_aliens_x):
            create_alien(ai_settings,screen,aliens,alien_number,row_number)

def check_fleet_edges(ai_settings,aliens):
    #responds if any aliens have reached edge
    for alien in aliens.sprites():
        if alien.check_edges():
            change_fleet_direction(ai_settings,aliens)
            break

def change_fleet_direction(ai_settings,aliens):
    #drop entire fleet and change fleet direction
    for alien in aliens.sprites():
        alien.rect.y += ai_settings.fleet_drop_speed
    ai_settings.fleet_direction *= -1

def ship_hit(ai_settings,stats,sb,screen,ship,aliens,bullets):
    #respond to ship being hit by alien
    if stats.ships_left > 0:
    #decrement ships_left
        stats.ships_left -= 1

        #update scoreboard
        sb.prep_ships()

        #empty list of aliens and bullets
        aliens.empty()
        bullets.empty()

        #create new fleet and center ship
        create_fleet(ai_settings,screen,ship,aliens)
        ship.center_ship()

        #pause
        sleep(0.5)
    
    else:
        stats.game_active = False
        pygame.mouse.set_visible(True)

def check_aliens_bottom(ai_settings,stats,sb,screen,ship,aliens,bullets):
    #check if aliens reached bottom
    screen_rect = screen.get_rect()
    for alien in aliens.sprites():
        if alien.rect.bottom >= screen_rect.bottom:
            #treat this as the same as if ship got hit
            ship_hit(ai_settings,stats,sb,screen,ship,aliens,bullets)
            break

def update_aliens(ai_settings,stats,sb,screen,ship,aliens,bullets):
    #check if fleet is at edge
    #update positions of all aliens
    check_fleet_edges(ai_settings,aliens)
    aliens.update()

    #look for alien ship collisions
    if pygame.sprite.spritecollideany(ship,aliens):
        ship_hit(ai_settings,stats,sb,screen,ship,aliens,bullets)
    
    #look for aliens hitting bottom of screen
    check_aliens_bottom(ai_settings,stats,sb,screen,ship,aliens,bullets)

def check_high_score(stats,sb):
    #check if theres a new high score
    if stats.score > stats.high_score:
        stats.high_score = stats.score
        sb.prep_high_score()