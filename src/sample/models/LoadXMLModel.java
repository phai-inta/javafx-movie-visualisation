package sample.models;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;

public class LoadXMLModel {
    Hashtable<String, Integer> keywordIndex;

    public LoadXMLModel() {
    }

    /**
     * Create the Document object and get back movies
     * @param selectedFile
     * @return movies
     */
    public ArrayList<Movie> parseXMLFile(File selectedFile){
        ArrayList<Movie> movies = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse(selectedFile.getPath());
            doc.getDocumentElement().normalize();
            movies = getMovies(doc);
            return movies;
        } catch (ParserConfigurationException e1) {
            e1.printStackTrace();
        } catch (SAXException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }

    /**
     * Parse movies from the Document object
     * @param doc
     * @return movies
     */
    private ArrayList<Movie> getMovies(Document doc){
        ArrayList<Movie> movies = new ArrayList<>();
        NodeList nList = doc.getElementsByTagName("movie");
        for (int temp = 0; temp < nList.getLength(); temp++) {
            Node nNode = nList.item(temp);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                int year = Integer.parseInt(eElement.getElementsByTagName("year").item(0).getTextContent());
                float rating = Float.parseFloat(eElement.getElementsByTagName("rating").item(0).getTextContent());
                ArrayList<Person> directors = getDirectors(eElement);
                ArrayList<String> genres = getGenres(eElement);
                ArrayList<String> keywords = getKeywords(eElement);
                Movie movie = new Movie(title, year, rating, directors, genres, keywords);
                movies.add(movie);
            }
        }
        return movies;
    }

    /**
     * Get Directors from XML element
     * @param eElement
     * @return persons
     */
    private ArrayList<Person> getDirectors(Element eElement){
        NodeList directorsList = eElement.getElementsByTagName("director");
        ArrayList<Person> directors = new ArrayList<>();
        for (int count = 0; count < directorsList.getLength(); count++) {
            Node nodeDirector = directorsList.item(count);
            if (nodeDirector.getNodeType() == nodeDirector.ELEMENT_NODE) {
                Element directorElement = (Element) nodeDirector;
                String name = directorElement.getElementsByTagName("name").item(0).getTextContent();
                Person director = new Person(name);
                directors.add(director);
            }
        }
        return directors;
    }

    /**
     * Get genres from element
     * @param eElement
     * @return genres
     */
    private ArrayList<String> getGenres(Element eElement){
        NodeList genresList = eElement.getElementsByTagName("item");
        ArrayList<String> genres = new ArrayList<>();
        for (int count = 0; count < genresList.getLength(); count++) {
            Node nodeItem = genresList.item(count);
            if (nodeItem.getNodeType() == nodeItem.ELEMENT_NODE) {
                Element item = (Element) nodeItem;
                String genre = item.getTextContent();
                genres.add(genre);
            }
        }
        return genres;
    }

    /**
     * Get keywords from elements
     * @param eElement
     * @return arraylist of string
     */
    private ArrayList<String> getKeywords(Element eElement){
        NodeList keywordsList = eElement.getElementsByTagName("kw");
        ArrayList<String> keywords = new ArrayList<>();
        for (int count = 0; count < keywordsList.getLength(); count++) {
            Node nodeItem = keywordsList.item(count);
            if (nodeItem.getNodeType() == nodeItem.ELEMENT_NODE) {
                Element item = (Element) nodeItem;
                String keyword = item.getTextContent();
                keywords.add(keyword);
            }
        }
        return keywords;
    }

    /**
     * Create an index of all keywords in the xml files (unsorted)
     * @param movies
     * @return Hashtable<String, Integer>
     */
    public Hashtable<String, Integer> createKeywordIndex(ArrayList<Movie> movies){
        int i = 0;
        keywordIndex = new Hashtable<>();

        for(Movie movie: movies){
            ArrayList<String> keywords = movie.getKeywords();
            for(String word: keywords) {
                if(keywordIndex.containsKey(word)){ // if the keyword is in the index, increase the frequency
                    Integer frequency = keywordIndex.get(word);
                    keywordIndex.put(word, frequency + 1);
                } else { // if not, put the frequency as 1
                    keywordIndex.put(word, 1);
                }
            }
        }
        return keywordIndex;
    }
}
