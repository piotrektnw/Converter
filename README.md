# Temperature converter

Convert temperatures in most efficient way - program is constantly developed. 

## Description

This is a command line program to convert temperatures according to user input.

This simple project is under constant development where current solutions are being improved, new solutions are implemented and code is reviewed in order to find its weaknesses. 
Each improvement or development will be committed and proved. 

## Authors

Author: Piotr Panek
Contact me: piotrektnw [ at ] outlook.com


## Version History

* 0.1
    (Date: 18.04.2021)
    * Initial Release
      - basic program functionalities:
      - accept and validate user input, 
      - convert temperature, 
      - display output
     
    (Date: 18.04.2021)
    * Improved input validation: 
      - input validation is provided by external method
    
    (Date: 22.04.2021)
    * Date manager:
      - Added module for date management:
        - date in LocalDate format - able to count time period and other linked with LocalDate,
      - Added advanced String input recognition: 
        - user input is compared against predefined list of words, case insensitive module counts number
        - - of similarities and returns word with most similarities with user input,
        - returned word is subject to user acceptation,
        - in date module it is used in order to accept two ways of 'month' name input: 
           - numeric (integer input) e.g. 1 = January,
           - alphabetic (String input) e.g. February = February, or (with typo) Fabrrary (recognition returns most similar) = February,
       - Added class with predefined list of messages,
       - Program gives user opportunity to choose module: 
            - date manager,
            - temperature converter.
    

## License

This project is license free.
