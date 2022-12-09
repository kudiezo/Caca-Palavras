# TRABALHO DO PROFESSOR

# ISPTEC
# DET
# Programação 2 (JAVA)

[ENUNCIADO]

# 1.  APRESENTAÇÃO 
 
Este projecto tem o objectivo de consolidar os conhecimentos adquiridos na disciplina de Programação II. 
 
# 2.  Descrição 
 
Neste trabalho deve implementar um programa que consegue encontrar um conjunto de palavras num caça-palavras.

a  c  a  t  g  u  d  k  h 
q  y  u  s  z  j  g  n  c 
b  m  c  o  d  i  g  o  q 
p  f  a  x  v  n  e  t  q 
o  c  g  j  u  a  t  d  k 
h  j  f  a  q  q  h  e  y 
j  f  g  q  e  r  t  g  j 
f  a  h  j  h  b  k  l  i 
r  o  v  o  m  a  y  s  l 
m  u  l  a  c  k  a  z  g 
t  s  y  z  l  o  k  e  u 
 
Dados um caça-palavras, representado por uma  matriz de letras de dimensão  m  x  n e uma  lista  de  palavras,  encontrar  a localização  no  caça-palavras  em  que  cada uma  das palavras pode ser encontrada. 
Uma  palavra  é  encontrada  no  caça-palavras  se  uma  sequencia  interrupta  de  letras  na tabela coincide com a palavra. A procura por uma palavra deve ser feita em qualquer das oito direcções no caça-palavras. 
A entrada começa com um único inteiro positivo em uma linha  que indica o número de caça-palavras que serão avaliados, seguido por uma linha em branco. Há também uma linha em branco entre cada dois caças-palavras consecutivos. 
Cada caça-palavra começa com um par de inteiros m e n numa linha, onde 1≤ m,n≤ 50. As próximas m linhas contêm n letras cada, representando a tabela de letras, ou o caça-palavras, onde as palavras devem ser encontradas. Após o caça-palavras, um inteiro k aparece numa linha, com 1 ≤ k ≤ 20. As próximas k linhas da entrada contêm a lista de palavras que serão procuradas, uma por linha. Estas palavras são constituídas por letras maiúsculas  ou  minúsculas  sem  espaços,  hífens, caracteres  acentuados,  cedilha  ou caracteres especiais. 
Para cada palavra em cada caso de teste, imprima um par de inteiros representado a sua localização no caça-palavras correspondente. Estes inteiros devem ser separados por um espaço em branco. 
O  primeiro  inteiro  é  a  linha  da  tabela  onde  a  primeira  letra  da  palavra  dada  pode  ser encontrada  (1  representa  a  linha  mais  acima  do  caça-palavras  e  m  representa  a  linha 
mais  a  baixo).  O  segundo inteiro  é  a  coluna  no  caça-palavras  onde  a  primeira  letra  da palavra dada pode ser encontrada (1 representa a coluna mais à esquerda e n representa 
a coluna mais à direita no caça-palavras). Se uma palavra for ser encontrada mais do que uma  vez  no  caça-palavras,  então  imprima  a  localização  da  ocorrência  mais  acima  da palavra, isto é, a ocorrência que situa a primeira letra da palavra mais próxima do topo do caça-palavras. 
Se duas ou mais palavras estiverem mais acima no caça-palavras, imprima a ocorrência mais à esquerda. 
Considere que todas as palavras podem ser encontradas pelo menos uma vez no caça-palavras.  As  saídas  de  dois  caça-palavras consecutivos  devem  ser  separadas  por  uma linha em branco. 

# 3.  Exemplo de Entrada 
 
2 
 
8 11 
a a c d e f g h i g g  
h n j p r o g r a m a 
a g u a k a o o s i t 
w u l k v k f l m c n 
f l q o g a y w i h d 
b a a v x j n s u p w 
s r r a e t y b h r b 
y u i q l x c n b j f 
4 
programa 
java 
angular 
byte 
 
5 6 
e h i u s s 
g l t o p z 
h t i m m x 
s o w h l r 
h t m l w l 
2 
html 
while 

# 4.  Exemplo de Saída 
 
2 4 
2 3 
1 2 
7 8 
 
1 2 
5 5


# 5.  Requisitos Técnicos 
 
•  O programa deve permitir entrada manual e a partir da leitura de um ficheiro. 
•  O  programa  deve  permitir  no  final  de  uma  sessão  de  trabalho  escrever  num ficheiro  de  texto  com  a  seguinte  nomenclatura  “YYYYMMDDhhmmss.txt“ em que YYYYMMDDhhmmss é o formato da data e hora actual. 
•  O projecto deve ser desenvolvido em grupos de 3 a 4 elementos no máximo. 
•  O trabalho deve ser desenvolvido em Java, utilizando o NetBeans. 
•  O programa deve ser comentado e formatado de forma legível. 
•  Todos os identificadores devem ter nomes significativos e seguir a convenção 
•  As classes devem estar organizadas em packages 
•  Para  estruturas  de  dados  devem  ser  utilizados exclusivamente  vectores  e matrizes 
•  Não é permitido a utilização dos conceitos da programação orientada a objectos. 
•  Deve  ser  produzido  um  relatório  com  um  máximo  de  4  páginas  onde  devem constar apenas: 
o  As estruturas de dados utilizadas (classes, vectores,…) 
o  A descrição resumida dos algoritmos mais complexos 
o  A justificação das opções técnicas tomadas 
o  O fluxograma dos algoritmos mais complexos 

Na  atribuição  das  notas  serão  privilegiados  os  programas  com  as  organizações, estruturas  de  dados,  algoritmos  e  as  opções  mais  inteligentes  e  bem  justificadas.  Do mesmo modo, também serão bonificados os trabalhos bem comentados e formatados.   