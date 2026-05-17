# SI_2026_lab2_233044

Име: Бојан Дулевски  
Индекс: 233044

## Цикломатска комплексност

**Формула:** M = E - N + 2P (рабови - јазли + 2) или поедноставно: M = број на одлуки + 1

### searchBookByTitle
Одлуки:
- if (title.isEmpty())
- for loop
- if (title match && !borrowed)
- if (results.isEmpty())

Вкупно: 4 одлуки → **M = 4 + 1 = 5**

### borrowBook
Одлуки:
- if (title.isEmpty() || author.isEmpty())
- for loop
- if (title && author match)
- if (!isBorrowed)

Вкупно: 4 одлуки → **M = 4 + 1 = 5**

## Цикломатска комплексност

### searchBookByTitle: M = 5
Одлуки: isEmpty check, for loop, if(match&&!borrowed), if(results.isEmpty)
4 одлуки + 1 = 5

### borrowBook: M = 5  
Одлуки: isEmpty||isEmpty check, for loop, if(match), if(!isBorrowed)
4 одлуки + 1 = 5

## CFG Дијаграми
[додај слики од дијаграмите]

## Every Statement тест случаи - searchBookByTitle
Минимум: 4 тест случаи
- TC1: Празен наслов → IllegalArgumentException
- TC2: Постоечка и достапна книга → враќа листа
- TC3: Непостоечка книга → null
- TC4: Изнајмена книга → null

## Every Branch тест случаи - borrowBook
Минимум: 5 тест случаи
- TC1: Празен title → исклучок
- TC2: Празен author → исклучок  
- TC3: Непостоечка книга → "Book not found"
- TC4: Достапна книга → успешно
- TC5: Веќе изнајмена → "already borrowed"

## Multiple Condition тест случаи
searchBookByTitle (A&&B): 4 комбинации (TT, TF, FT, FF)
borrowBook (A||B): 4 комбинации (TT, TF, FT, FF)
