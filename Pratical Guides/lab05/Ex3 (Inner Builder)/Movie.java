package Ex3;                                                   // IF OUR CLASSES AREN'T BEING FOUND, TRY REMOVING THIS LINE
import java.util.*;
public class Movie {                                           // In order to try this class, it's required to first create
   private final String title;                                 // Person and Place classes and their constructors 
   private final int year;
   private final Person director;
   private final Person writer;
   private final String series;
   private final List<Person> cast;
   private final List<Place> locations;
   private final List<String> languages;
   private final List<String> genres;
   private final boolean isTelevision;
   private final boolean isNetflix;
   private final boolean isIndependent;
   /* public Movie(                                            // This code is not necessary and should not be uncommented
         final String movieTitle,
         final int movieYear,
         final Person movieDirector,
         final Person movieWriter,
         final String movieSeries,
         final List<Person> movieCast,
         final List<Place> movieLocations,
         final List<String> movieLanguages,
         final List<String> movieGenres,
         final boolean television,
         final boolean netflix,
         final boolean independent)    {
         this.title = movieTitle;
         this.year = movieYear;
         this.director = movieDirector;
         this.writer = movieWriter;
         this.series = movieSeries;
         this.cast = movieCast;
         this.locations = movieLocations;
         this.languages = movieLanguages;
         this.genres = movieGenres;
         this.isTelevision = television;
         this.isNetflix = netflix;
         this.isIndependent = independent;
      } */
   // Our approach was to create a inner builder pattern
   public static class Builder {
      // Required parameters
      private final String title;
      private final int year;
      private final Person director;
      private final Person writer;
      // Optional parameters - initialized to default values
      private String series = "";
      private List<Person> cast = new List<Person>(){};
      private List<Place> locations = new List<Place>(); 
      private List<String> languages = new List<String>(); 
      private List<String> genres = new List<String>(); 
      private boolean isTelevision = false;
      private boolean isNetflix = false;
      private boolean isIndependent = false;
      // Contructor for Builder passing the required parameters of a Movie
      public Builder(String title, int year, Person director, Person writer){
         this.title = title;
         this.year = year;
         this.director = director;
         this.writer = writer;
      }
      // Optionall parameters are processed separately
      public Builder series(String val){
         series = val;
         return this;
      }
      public Builder cast(List<Person> val){
         cast.addAll(val);
         return this;
      }
      public Builder locations(List<Place> val){
         locations.addAll(val);
         return this;
      }
      public Builder languages(List<String> val){
         languages.addAll(val);
         return this;
      }
      public Builder genres(List<String> val){
         genres.addAll(val);
         return this;
      }
      public Builder isTelevision(){
         isTelevision = true;
         return this;
      }
      public Builder isNetflix(){
         isNetflix = true;
         return this;
      }
      public Builder isIndependent(){
         isIndependent = true;
         return this;
      }
      // build() method to convert Builder class to Movie (implemented as the Contructor Movie() with Builder parameter)
      public Movie build() {
         return new Movie(this);
      }
   } // END OF CLASS BUILDER
   private Movie(Builder builder){ // Contructor for Movie passing Builder
      title = builder.title;
      year = builder.year;
      director = builder.director;
      writer = builder.writer;
      series = builder.series;
      cast = builder.cast;
      locations = builder.locations;
      languages = builder.languages;
      genres = builder.genres;
      isTelevision = builder.isTelevision;
      isNetflix = builder.isNetflix;
      isIndependent = builder.isIndependent;
   }
} // END OF CLASS MOVIE
/* In the main class its possible to create a Movie doing the following line of code (considering castList a List<Person>)

   Movie newMovie =  new Builer("title",2022,director,writer).series("GOT").cast(castList).isNetflix();

   This will create a newMovie with the required parameters and other 3 optional parameters and the reminding
   parameters will be empty, null or false.*/