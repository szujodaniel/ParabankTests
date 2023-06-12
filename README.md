#   [Parabank](https://parabank.parasoft.com/parabank/index.htm) 
##  Parabank "Account Services" Automated Test Cases using: Maven,Selenium,TestNG


#	High Level Test Cases
##	Account Services
### Open new account
>   The user can choose various types of account (checking or savings) and open a new account. 
### Transfer Funds
>	The user can transfer funds between existing accounts.
### Bill Pay
>   The user can pay bills by giving the necessary information and clicking the “send payment” button.
### Find Transactions
>  	The user can find transactions by giving the following information:
>  	Transaction ID
>  	Find by Date
>  	Find by Date Range
>  	Find by Amount
### Update Contact Info
>  	The user can update profile information by giving the necessary information and clicking the “Update profile” button.
### Request Loan
>  	The user can request a loan from existing accounts by giving the following informations:
>   -	Loan Amount
>   -	Down Payment
>   -	From account
### Log out
>  	The user can log out from the main page and send back to the Customer Login page.
    
#   Test Techniques - Login - Decision Table

|Causes|Rule 1|Rule 2|Rule 3|Rule 4|Rule 5|Rule 6|Rule 7|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Valid Username|-|-|True|True|True|False|False|
|Valid Password|-|True|-|True|False|True|False|
|Empty Username|True|True|False|False|False|False|False|
|Empty Password|True|False|True|False|False|False|False|
|Effects|Rule 1|Rule 2|Rule 3|Rule 4|Rule 5|Rule 6|Rule 7|
|Error: Please enter a username and password|True|True|True|False|False|False|False|
|Error: The username and password could not be verified|False|False|False|False|True|True|True|
|Succesful Login|False|False|False|True|False|False|False|

#   Account Services - Request Loan - Boundary value analysis

## Loan Processor: Down Payment (Down payment must be bigger than 50% Loan)
- From account: Existing account
- Treshold: 50%
- Available funds: 1000
- Loan Amount ($): 1000
- Boundary analysis on Down payment values:
    - 	Invalid values ($) : Down Payment value < 500
    - 	Valid values ($): 500 =< Down Payment value
    -  	Boundary values: 499, 500, 501

## Loan Processor: Available Funds (Down payment can't be more than Availabe funds on the account)
- From account: Existing account
- Treshold: 50%
- Available funds: 1000
- Loan Amount ($): 1000
- Boundary analysis on Down payment:
    - 	Invalid values ($) : 1000 < Down Payment value
    - 	Valid values ($): 0 - 1000 Down Payment value
    - 	Boundary values: 999,1000,1001
## Loan Processor: Combined (Down payment must be bigger than 50% Loan and can’t be more than Available funds on the account)
- From account: Existing account
- Treshold: 50%
- Available funds: 1000
- Loan Amount ($): 1000
- Boundary analysis on Down payment values:
    - 	Invalid values ($) : Down Payment value > 1000 OR Down Payment value < 500
    - 	Valid values ($): 500 - 1000 Down Payment value
    - 	Boundary values: 499, 500, 1000, 1001
