

  How to execute :-
    run the main file RelevantDoctors.java from an IDE or

     need maven installed for creating an executable jar

     execute -
     mvn compile
     mvn package
     cd target
     java -jar FILENAME.jar


 * RELEVANT DOCTORS:-

  The list of doctors is first pre processed to map each doctor to their city. Assumption here is no two different
  states or country will have  a city with the same name.

  After the pre processing step, for a given input doctor we can retrieve the doctors for that city in constant
  time.

  pre processing is useful if we are going to hold the list of all doctors in the memory. But if like in the real world
  applications the list is maintained in a database like a relational database the step can be
  completely avoided.

  After which we can do a match on the specialization of the doctor and return a sorted list of those doctors based on
  their ratings.

 * IMPROVEMENTS: -

  In this program we return doctors based on the specialization and ratings.
  It could be made better by considering the zipcode of the given doctor. Zipcodes can be used to retrieve
  latitudes and longitudes which can help in retrieving all the doctors in say a 50 mile radius.
