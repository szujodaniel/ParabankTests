# ParabankTests
Parabank "Account Services" Automated Test Cases using: Maven,Selenium,TestNG

#	High Level Test Cases
##	Account Services
### Open new account
    The user can choose various types of account (checking or savings) and open a new account. 
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
    
Test Techniques - Login - Decision Table

|Causes|Rule 1|Rule 2|Rule 3|Rule 4|Rule 5|Rule 6|Rule 7|
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
|Valid Username|-|-|True|True|True|False|False|
