Style guide
===========
Based on CS50 style guide: https://manual.cs50.net/style/
---------------------------------------------------------

**Algemene regels:**
* Accolades (curly braces) van bijvoorbeeld classes, methods, statements en loops die samen de body vormen, moeten recht onder elkaar staan.
* Bij iedere regel binnen de body moet ingesprongen worden met 1 tab. Bij het gebruik van accolades binnen een body moet opnieuw met een extra tab worden ingesprongen. Ieder codeblok wordt zo herkenbaar doordat de inhoud ervan recht onder elkaar staat.
* Bij vergelijkingen en declaraties wordt rondom <, > en = een enkele spatie gebruikt. 

**Comments (https://manual.cs50.net/style/#comments):**
* Gebruik commentaar om zo duidelijk mogelijk uit te leggen wat de code impliceert. Doe dat volgens de onderstaande manieren.
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
  \*     
  \* * */    

**Classes:**
* **public class** [ClassName]     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// declarations     
          
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// method 1      
      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// method 2      
      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// method 3      
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}

**Methods (https://manual.cs50.net/style/#functions):**
* **public void** [object]     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// content     
}   


**Loops (https://manual.cs50.net/style/#loops):**
* do     
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// execute these instructions one time under given circumstances      
}    
while ();
* for ()     
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// execute these instructions for given circumstances     
}     
* while ()      
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// keep executing these instructions under given circumstances      
}
* Let op de spatie voor de haakjes.

**Statements:**
* If-statements (https://manual.cs50.net/style/#conditions)
- if (condition 1)          
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
}     
else if (condition 2)     
{    
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
}     
else   
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this          
}  
* try     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this       
}      
catch ()      
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
}
* Switch-statement (https://manual.cs50.net/style/#switches):
- switch (n)     
{     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;case 1:     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;break;     
       
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;case 2:     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;break;     
       
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;case 3:     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;// do this     
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;break;   
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;}    
* Let op de witregel in switch-statements tussen iedere case.
* Let ook bij statements op de spatie voor de haakjes.