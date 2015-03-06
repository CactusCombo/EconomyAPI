# EconomyAPI
EconomyAPI - First Release

####How to install:
Add the following classes to your project:

            EconomyAPI.java
            
            MoneyStorage.java

####How to use

on your onEnable() put the following:

            MoneyStorage.getInstance().create(this);

You can now add this constructor:

            MoneyStorage moneystorage = MoneyStorage.getInstance();

####Methods

            getBalance(p.getName());
            setBalance(p.getName(), 20.0);
            addBalance(p.getName(), 10.0);
            removeBalance(p.getName(), 10.0);

####Example Usage

        if(cmd.getName().equalsIgnoreCase("balance")) {
            Player p = (Player)sender;
            getBalance(p.getName());
        }
