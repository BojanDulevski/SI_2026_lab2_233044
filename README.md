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
