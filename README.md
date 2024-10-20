Money Conversion Program-
1. Overview: 
      This is a simple money conversion program that allows users between six different currencies to convert a given amout of money. 
      After performing conversions, the program will save a log of each conversion in a JSON file for record-keeping and further reference.
  
  Note: As the the programm is based on live exchange rates, the user must have access to internet for the programm to function correctly. 

2. Features:
User can input the amount to be converted and select the desired conversion option.
After performing multiple conversions, the program generates a JSON file that contains the conversion records.
Each record in the JSON file includes the source currency, the target currency, and the converted amount.

3. Supported Currencies:
The following currencies are supported by the program:

   1) Dollar -> Argentine peso
   2) Argentine peso -> Dollar
   3) Dollar -> Mexican peso
   4) Mexican peso -> Dollar
   5) Dollar -> Colombian peso
   6) Colombian peso -> Dollar

4. How It Works:
Choose Currencies: The user selects the source currency and the target currency from the supported currencies.
Enter Amount: The user inputs the amount of money they want to convert.
Conversion: The program performs the conversion based on live exchange rates.
JSON Log: After performing a conversion, the program adds the conversion record to a list. Once all conversions are completed, the program writes the list of conversions to a JSON file.
