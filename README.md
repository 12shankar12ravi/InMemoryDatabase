# InMemoryDatabase
  We need to design a In memory database that serves basic functionalities of the database.

The objective is to design and implement an in-memory SQL-like database, which should support the following set of operations / functionality:

1. It should be possible to create or delete tables in a database.
2. A table definition comprises columns which have types. 
3. They can also have constraintsThe supported column types are string and int.
4. The string type can have a maximum length of 20 characters.
5. The int type can have a minimum value of -1024 and a maximum value of 1024.
6. Support for mandatory fields (tagging a column as required)
7. It should be possible to insert records in a table.
8. It should be possible to print all records in a table.
9. It should be possible to filter and display records whose column values match a given value.
