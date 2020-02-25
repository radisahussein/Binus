import pygame
from pygame.sprite import Group
from settings import Settings
from game_stats import GameStats
from scoreboard import Scoreboard
from button import Button
from ship import Ship
from alien import Alien
import game_functions as gf


def run_game():
    #Initialize game and create screen object
    pygame.init()
    ai_settings = Settings()
    screen = pygame.display.set_mode((ai_settings.screen_width,ai_settings.screen_height))
    pygame.display.set_caption('Alien Invastion')

    #make play button
    play_button = Button(ai_settings,screen,'Play')

    #create instance to store game stats and create scoreboard
    stats = GameStats(ai_settings)
    sb = Scoreboard(ai_settings,screen,stats)

    #make ship
    ship = Ship(ai_settings,screen)

    #make alien
    alien = Alien(ai_settings,screen)

    #make group to store bullets
    bullets = Group()
    #make group of aliens
    aliens = Group()

    #create first fleet of aliens
    gf.create_fleet(ai_settings,screen,ship,aliens)

    #set background color
    bg_color = (230,230,230)


    #Main loop for the game
    while True:
        
    
        #Watch for keyboard and mouse events
        gf.check_events(ai_settings,screen,stats,sb,play_button,ship,aliens,bullets)
        if stats.game_active:
            ship.update()
            gf.update_bullets(ai_settings,screen,stats,sb,ship,aliens,bullets)
            gf.update_aliens(ai_settings,stats,sb,screen,ship, aliens,bullets)
 
        gf.update_screen(ai_settings,screen,stats,sb,ship,aliens,bullets,play_button)

run_game()
