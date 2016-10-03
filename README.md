
# What is it?
MoneyTextInput allows you to create a textinput with a money mask.

#How to use it?
##Essentials

####Setting up

The TextInput has a default setting for american dollar currency $, so just call it as any other native android component.

```java
MoneyTextInput moneyTextInput;

 moneyTextInput=(MoneyTextInput)findViewById(R.id.money_text_input);
```

Create its xml with the properties you need

```java
    <com.moises.moneytextinput.textInput.MoneyTextInput
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:id="@+id/money_text_input" />
```



####Changing the Symbol

The symbol in front of the amount can be change to others already set in default

- ```moneyTextInput.setSymbol(Constants.POUND);```

If you need a different symbol from the ones I have, make me know, I may update the project, or you can use the method to use your own.

```java
  moneyTextInput1.setSideTextNoSymbol("Money ");
```


####Changing the settings

You can obtain the values from the TextInput as wheter the value is 0, the value with cents or the value with no cents, it's returned as a String.

- ```moneyTextInput.isValueEmpty();```
- ```moneyTextInput.bringCleanAmount();```
- ```moneyTextInput.bringCleanAmountNoCents();```

You can change if you want to use cents or not, or only whole numbers, the method has values set in default

- ```moneyTextInput.setState(Constants.WHOLE_NO_CENTS);```


#Setup

##Runtime permissions
No permissions are required


License
=======

    Copyright 2015 Jacek Kwiecień.

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
