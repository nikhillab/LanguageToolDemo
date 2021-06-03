
<h1>LanguageTool in Java applications</h1>

## OVERVIEW
Simple rest base application for checking text using LanguageTool.

## API
### GET /language/list
List of all language supported by LanguageTool

### GET /language/{id}
	Name of the language for a given ID
### POST /language/test

```
	Param String text (text to test)
	Param int id (for which language)
```

Response:
   fromPos : from where sentence is incorrect
   toPos: to where sentence is incorrect
   message : What is the error/any suggestion 
   List<String> suggestion :suggestion for the correction



	

