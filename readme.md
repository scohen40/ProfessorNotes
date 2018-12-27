# ProfessorNotes
The ProfessorNotes app allows teachers to take written and vocal notes throughout the day so they can keep track of student's behavior, jot down a note about a meeting they had with a student or about a student, etc.

**Relevant Links**
***
* https://www.javahelps.com/2015/07/android-memo-application.html
* https://www.javahelps.com/2015/03/advanced-android-database.html
* https://developer.android.com/guide/topics/media/mediarecorder


**To Do**
***
* Welcome View
* Main View
  * List of Student Records
      * onClick Record Brings up Student Information View
      * Delete Student Record Option
      * Popup Delete Confirmation
  * Add New Student FAB
      * onClick Opens New Student View
* New Student View
  * Toolbar Title: "Create New Student"
  * TextViews:
      * Course
      * First Name
      * Last Name
      * Main Notes Area
  * Buttons:
      * Add Text Notes Area
      * Add Voice Note
      * Play Voice Note(s) (separate one for each note created with a description)
      * More - Information Text Fields(Optional), would go right after 'Last Name' - e.g. School/Institution, grade/class standing
* Student Information View - not editable
  * Toolbar Title: Student First and Last Name
  * Text Views
      * Course
      * First Name
      * Last Name
      * Text Notes View(s)
   * Buttons
      * Play Voice Note(s) (separate one for each note, with a description)
      * Edit Student Information
      
* Edit Student View - editable
  * Toolbar Title: "Create New Student"
  * TextViews: 
      * Course
      * First Name
      * Last Name
      * Text Notes View(s)
  * Buttons:
      * Add Text Notes Area
      * Add Voice Note
      * Play Voice Note(s) (separate one for each note, with a description)
      * More - Information Text Fields(Optional), would go right after 'Last Name'

