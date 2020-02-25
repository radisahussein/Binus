import requests
from bs4 import BeautifulSoup
from tkinter import *


#--------------------------PROGRAM---------------------------#

class findGithub():                     #class for finding github repositories
    
    def __init__(self,user):
        self.user = str(user)
        self.link = 'https://www.github.com/' + self.user + '?tab=repositories' #link for repositories page of a given user
        self.site = requests.get(self.link)
    
    def checkSite(self):
        #function to check if site is accessible
        #if not, could be due to no connection, wrong username, or private page
        if self.site.status_code == 200:
            return True
        else:
            return False
    
    def getContent(self):
        #function to get the content from the link

        source = self.site.content                                      #variable to store page content of accessed website from requests
        soup = BeautifulSoup(source)                                    #beautiful soup module to process the source

        urls = []

        for h3_tags in soup.find_all('h3',{'class':'wb-break-all'}):    #for loop finding all h3 tags with the specified class
            a_tags = h3_tags.find('a', href = True)                     #from the h3 tags, finding a tags with a HREF attribute
            urls.append(a_tags['href'])

        finduser = findGithub(self.user)
        global newurls
        newurls = []
        for url in urls:
            newurls.append('https://github.com' + str(url))             #Adding 'https://github.com to the href tags making a valid link
        
        
        for widget in resultframe.winfo_children():             #Destroy Widgets inside Resultframes
            widget.destroy()
        
        for widget in showingframe.winfo_children():            #Destroy Widgets inside Showingframes
            widget.destroy()

        labels = []
        if len(newurls) > 15:                                   #Limit on number of repositories, more than 15, will end up going out of screen
            del newurls[15:]
            newurls.append('and more')
        elif len(newurls) == 0:                                 #If no repositories found, will print out this label
            norepo = 'This user has no repositories'
            norepolbl = Label(showingframe,text=norepo,font=('Arial',13),fg='red' )
            norepolbl.grid(row=2,column=1)

        # "Showing users profile" label

        showingprofile = 'Showing ' + inputuser.get() + "'s Profile"
        showinglabel = Label(showingframe,text=showingprofile,font=('Arial',13),bg='gray26',fg='white')
        showinglabel.grid(row=0,column=1)

        #for loop printing of repositories in the form of labels
        for i in range(len(newurls)):
            labels.append(Label(resultframe,text=newurls[i]))
            labels[i].grid(row=i,column=1)
 




def submitclick():                                              #Function called when submit button is clicked
    finduser = findGithub(inputuser.get())                      #Initializing variable as class

    if finduser.checkSite() is True:
        finduser.getContent()

    else:
        for widget in showingframe.winfo_children():            #making sure the showing frame and result frame is clear
            widget.destroy()
        for widgets in resultframe.winfo_children():    
            widgets.destroy()


        # Labels for when checksite returns false
        
        showingprofile = "User not found!"
        internet = 'Make sure you have a good internet connection!'
        showinglabel = Label(showingframe,text=showingprofile,font=('Arial',13),fg='firebrick1')
        internetlabel = Label(showingframe,text=internet,font=('Arial',13),fg='light slate gray')
        showinglabel.grid(row=0,column=1)
        internetlabel.grid(row=2,column=1)
    

#-----------------------TKINTER DESIGN--------------------------#

root = Tk()
root.title('CenWebS')
root.geometry('400x600')

#Set window ----------------------------------------------------------------------------------

cenWebsLabel = Label(root,text='CenWebS',font=('Helvetica',40),relief='groove',bd=4,padx=77,bg='gray26',fg='white smoke')
cenWebsLabel.grid(column=0,row=0)

#github label frame ------------------------------------------------------------

githubFrame = Frame(root)
githubFrame.grid(row=1,column=0)

githublabel = Label(githubFrame,text='Github Web Scraping',font=('Arial',20),relief=RIDGE,bd=4)
githublabel.grid(row=0,column=0)

#input frame and widgets -------------------------------------------------------

inputframe = Frame(root,bd=4,relief='ridge',padx=10,pady=10)
inputframe.grid(row=2,column=0)

inputuser = Entry(inputframe,font=('Arial',10))
inputuser.grid(row=2,column=2)

labelinput = Label(inputframe,text='Username: ', font=('Arial',15))
labelinput.grid(row=2,column=1)

submitbutton = Button(inputframe,text='Search',font=('Arial',13),command=submitclick)
submitbutton.grid(row=3,column=1,columnspan=2)

#Showing Profile frame and widget ---------------------------------------------------------

showingframe = Frame(root,padx=10,pady=10,)
showingframe.grid(row=3,column=0)

#Result frames and widgets ----------------------------------------------

resultframe = Frame(root,bd=4,relief='flat')
resultframe.grid(row=4,column=0,rowspan=10)


#Main loop ------------------------------------

root.mainloop()