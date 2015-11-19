# turbulent-octo-quack
## Data Structures Mini Project - Lossless Data Compression - Huffman Coding (read and input to file)
Data Structures Mini Project - 2015

##Purpose:
This is a 'mini' project of sorts. Compresses text files and decodes using Huffman Codes.  
Not meant to be implemented in real-world situations. May break at the slightest touch.

Package huffmancoding: 
+ Very unprofessional, loads of bugs.
+ Does not actually compress files.
+ Improper abstraction of classes
+ No comments in code

To use, import the HuffmanCoding class from the huffmancoding package into the folder of your client class  
`import huffmancoding.HuffmanCoding;`

##How it works:  
Uses Huffman Coding algorithm to generate optimal prefix codes for all the characters in the input text, then appropriately substitutes in a another file.  
The dictionary is also recorded in the same file. The `NUL` character is used as a delimiter to differentiate between the different sections of the compresses file.  
Unfortunately, due to the overhead in transmitting the dictionary and inefficiencies in encoding the data, file sizes of compressed data seem larger than original files. Still trying to figure out why, and how to rectify the situation.
