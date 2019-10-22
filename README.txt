COS80007 - ADVANCED JAVA

101927540 - Lam Tu 
101800900 - Lamphai Intathep

EXPECTED MARKS: 300

----- INSTRUCTION ON HOW TO RUN THE CODE -----
Copy all files in the src folder (three folders: controllers, models, views, Main.java, imdb.xml)
Run the Main.java file
A window should pop up with the option to "Choose Source"
Pick your imdb file
Click "Parse XML". The file should be parsed and the content will display in the textarea below the ParseXML button
Click "Continue to search"
Enter the keyword you want to search into the textbox below "Keyword:"
Click "Search". All movies that have the keyword will be shown in the textarea.
Pick the top keywords you want (top 3, 5, 8, 10)
Click "PieChart" or  "BarChart". A new windows will pop up with the appropriate visualisation.
You can close the window with the data visualisation to pick another visualisation with the same result
Suggested keyword: mafia, prison, new-york

------------- FEATURE COMPLETED -------------
1. Provide flow charts of the logical details

2. Provide UML diagrams for the solution

3. Relate your work with MVC - DONE
Other than the Main class, all other classes were separate into three folders: controllers, models, views. Each view has its own controllers to connect to the models. All business logic works were done in the model layer. For example: loading and parsing XML file was done in the LoadXML model.

4. Use JavaFX and advanced java features - DONE
JavaFX: Geometry.Insets, Geometry.Pos, BarChart, NumberAxis, XYChart, PieChart, GridPane, HBox were used
Advanced Java features: a HashTable was created to store the keywords with their frequency. Then using Java Stream to sort the HashTable

5. Use event handling - DONE
ChooseFileEventHandler, ParseFileEventHandler, ContinueToSearchEventHandler, SearchMovieEventHandler, BarChartBtnPressEventHandler, PieChartBtnPressEventHandler were all implemented to handle user interaction events.

6. Use Graphics2D as far as possible - DONE

7. Include reasonable documentation according to Javadoc standards - DONE
Methods are commented using Javadoc standards. At places where other sources such as stackoverflow were used, there are also comments to show the original link to the resource.

8. Formally written word-version report with screenshot

9. README - DONE
README.txt was created and included with the requirements.

----- PRESENCE OF CODES FROM OTHER SOURCES -----
The original DOM parser was extracted from the XML demonstration zip file in week 7. However, the code was refactored so that it implements the MVC model by Lam
For the visualisation, the solution for lab 6 provided on Canvas was used as a reference for our code. Lamphai refactored the code to separate it according to MVC model
We also looked at Stackoverflow to understand and use LinkedHashMap to sort the keywords index by frequency