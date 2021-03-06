Style guide
===========
Based on CS50 style guide: https://manual.cs50.net/style/
---------------------------------------------------------

**Algemene regels:**
* Accolades (_curly braces_) van bijvoorbeeld _classes, methods, statements_ en _loops_ die samen de _body_ vormen, moeten recht onder elkaar staan. Iedere accolade staat afzonderlijk op een regel.
* Bij iedere regel binnen de _body_ moet ingesprongen worden met 1 tab. Bij het gebruik van accolades binnen een body moet opnieuw met een extra tab worden ingesprongen. Ieder codeblok wordt zo herkenbaar doordat de inhoud ervan recht onder elkaar staat.
* Bij vergelijkingen en declaraties wordt rondom _operators_ (zoals <, > en =) een enkele spatie gebruikt (bijv. x < 5 of n == 10). 
* Tussen ieder codeblok wordt een witregel gehanteerd.
* Namen van _classes_ en _interfaces_ beginnen _lower case_, maar ieder nieuw woord binnen die naam begint in _upper case_ (bijv. phoneNumber).
* Namen van _methods_ en variabelen zijn altijd _lower case_.
* Namen van constanten zijn altijd _upper case_.
* De puntkomma (;) volgt zonder spatie achter de instructie (bijv. setContentView(R.layout._main_); ).
       
       
**Comments (https://manual.cs50.net/style/#comments):**
* Gebruik commentaar om zo duidelijk mogelijk uit te leggen wat de code impliceert. 
* Gebruik in ieder geval voor ieder codeblok commentaar om de werking van het codeblok toe te lichten. Doe dat volgens de onderstaande conventies.
* Top comments:
  - /* * * * * * * * * * * * * * * * * *  
   \* [name file]    
   \*       
   \* [name programmer]    
   \* [email adress programmer]    
   \* [student number]    
   \*   
   \* [file subscription]   
   \*   
   \* * * * * * * * * * * * * * * * * */
* One-line comments:
  - // one-line comment
  - Gebruik aan het begin van je commentaar geen hoofdletters en aan het eind geen punt.
* Multi-line comments:
  - /* * *   
  \* [comments]     
  \* [comments]        
  \* * */   
* Let op de enkele spatie na een asterisk (*) en na een slash (/). 
      
       
**Classes:**
* **public class** [ClassName]     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// declarations     
          
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// code block 1      
      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// code block 2      
      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// code block 3      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}
* Maak eventueel gebruik van _access modifiers_ voorafgaand aan **class** (http://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html):
  - <table>
	<th colspan="5">Toegankelijkheid/zichtbaarheid van class</th>
	<tr>
		<td><b>Modifier</b></td>
		<td><b>Class</b></td>
		<td><b>Package</b></td>
		<td><b>Subclass</b></td>
		<td><b>World</b></td>
	</tr>
	<tr>
		<td><b>public</b></td>
		<td>Ja</td>
		<td>Ja</td>
		<td>Ja</td>
		<td>Ja</td>
	</tr>
	<tr>
		<td><b>protected</b></td>
		<td>Ja</td>
		<td>Ja</td>
		<td>Ja</td>
		<td>Nee</td>
	</tr>
	<tr>
		<td><b><i>geen</i></b></td>
		<td>Ja</td>
		<td>Ja</td>
		<td>Nee</td>
		<td>Nee</td>
	</tr>
	<tr>
		<td><b>private</b></td>
		<td>Ja</td>
		<td>Nee</td>
		<td>Nee</td>
		<td>Nee</td>
	</tr>
</table>
           
       
**Methods and objects (https://manual.cs50.net/style/#functions):**
* **public void** [method]     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// content     
}
* Gebruik geen spatie voor de haakjes bij _methods_ (bijv. onCreate(); ).
* Het koppelen van _methods_ aan _objects_ gebeurt zonder spaties (bijv. object.method(); ).
     
**Loops (https://manual.cs50.net/style/#loops):**
* **do**     
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// execute these instructions one time under given circumstances      
}    
**while** ();
* **for** ()     
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// execute these instructions for given circumstances     
}     
* **while** ()      
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// keep executing these instructions under given circumstances      
}
* Let op de spatie voor de haakjes.
     
       
**Statements:**
* If-statements (https://manual.cs50.net/style/#conditions)
  - **if** (condition 1)          
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
}     
**else if** (condition 2)     
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
}     
**else**   
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this          
}  
* Try-catch block: 
  - **try**     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this       
}      
**catch** ()      
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
}
* Switch-statement (https://manual.cs50.net/style/#switches):
   - **switch** (n)     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**case** 1:     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**break**;     
       
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**case** 2:     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**break**;     
       
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**case** 3:     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**break**;   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}    
* Let op de witregel in _switch-statements_ tussen iedere _case_.
* Let ook bij _statements_ op de spatie voor de haakjes.