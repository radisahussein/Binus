class Spell:
    def __init__(self,incantation,name):
        self.name = name
        self.incantation = incantation

    def __str__(self):
        return self.name + ' ' + self.incantation + '\n' + self.get_description()

    def get_description(self):
        return "No Description"
    
    def execute(self):
        print(self.incantation)
    
class Accio(Spell):
    def __init__(self):
        Spell.__init__(self,'Accio','Summoning Charm')

    #Add get_description method for accio in order for print(Accio()) to display the appropriate description
    def get_description(self):
        return 'This charm summons an object to the caster, potentially over a significant dsitance'
        
#Indentation removed for class Confundo
class Confundo(Spell):
    def __init__(self):
        Spell.__init__(self,'Confundo','Confundus Charm')
    
    def get_description(self):
        return 'Causes the victum to become confused and befuddled'

#Indentation removed for study_spell
def study_spell(spell):
        print(spell)

spell = Accio()

spell.execute()

study_spell(spell)

study_spell(Confundo())



