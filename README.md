Walking Buddah:

Definitions:
  
   Mantra - Buddhist Prayer
   Stupa - Buddhist religious Artificat, used as a 'focus' for prayer.
   Circumambulation - Walking around a Stupa, generally while praying

Goals:
  
   Virtual Circumambulation:  Allow users who may not have a physical stupa nearby
     or who may be unable to walk, to virtually move around a stupa.

   Mantras:  Provide a set of prayers to users which allows them to recite
    traditional buddhist prayers.  Display these during the cirucumambulation to allow interactive use... Read alloud for deaf users?

   Extensibility:  Allow users to Add their own Stupas and or Prayers to the application

   Add Support:  Put google adds in unobtrusive locations to generate revenue to support further dev, potentially donate procedes to worth groups.

   Support for both a series of still images, and video.

Extensibility Framework:

   JSON files
   
   On SD Card a directory:

   WALKING_BUDDAH
    |-STUPAS
    |   |-STUPA1
    |   |   |-STUPA1.JSON
    |   |   |-STUPAIMAGES
    |   |   |    |pic1.jpg
    |   |   |    |pic2.jpg
    |   |   |    |pic3.jpj
    |   |-STUPA2
    |   |   |-STUPA2.JSON
    |   |   |-STUPAIMAGES
    |   |   |    |pic1.video
    |   |...
    |   |-STUPA(n)
    |
    |
    |
    |- PRAYERS
    |    |-prayer1.json
    |    |-prayer2.json
    |- FONTS
    |    | - customFont1.tff
    |    | - cutomFont2.tff


OBJECT MODELS:

   Stupa:
	NAME:string (<40char??) // we do this just for display purposes... might not really enforce
        LAT: // google latlng format
	LNG:    
	TYPE: string // pic or mov
	DESC: string (<255 char??) // tell us about yourself stupa
	IMAGES: string[], // list of images in order
   Prayer:
	NAME:string (<40char??) // we do this just for display purposes... might not really enforce
	TEXT_ENG: string //english version
	TEXT_PHON: string //phonetic (in tibetan) version
	TEXT_PHON_FONT: string // font used for this
	TEXT_NON_ENG: string //Got a special encoding?  Like sanskrit?  May want to all custom fonts even
	TEXT_NON_ENG_FONT: string // font used for this


UI Description:
 
    4 Pages:

	1) Splash
           - say cute things about the app, point people at your website?
	2) Prayer Selection
	   - select a prayer, read its description, enjoy a pleasant background.  Have a machine pray at you.  Creepy.
	3) Stupa Selection
	   - select a stupa, read its description, view it's location on google maps.
	4) Action! 
	   - Look at that turtle go bro, also you can still get prayed at by a machine because why not.

    Possible extensions:

	- Customizable for reuse by temples so they can "place add here" for themselves (i.e website links etc...)
	- New stupa sets!
	- Prayer dedication on social media (social media tie ins?)

