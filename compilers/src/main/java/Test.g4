grammar Test;

ID : [a-z]+;
INT : [0-9]+;
WS : [ \r\t\n]+ -> skip;
a : b INT;
b : ID ID;

