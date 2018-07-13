# Convert JSON to XML

This is a command-line tool that reads JSON from stdin and writes XML to stdout. The following conversion rules are used:

- A field is converted to an XML element with the same name. The contents of the element is the value of the field.
- Arrays are converted to an element with the same name, unless the JSON document is an array itself, in which case the array will have no name. Elements within an array have either `object` or   value` as their name.
- The document element of the generated document is always `doc`.

## An example

```
{
  "field1": 1,
  "field2": "text",
  "field3": {
    "subfield1": 2,
    "subfield2": true
  },
  "items": [
    3,
    "text",
    {
      "subfield1": false,
      "subfield2": 4
    }
  ]
}
```
```
<?xml version="1.0" encoding="UTF-8"?>
<doc>
   <field1>1</field1>
   <field2>text</field2>
   <field3>
      <subfield1>2</subfield1>
      <subfield2>true</subfield2>
   </field3>
   <items>
      <value>3</value>
      <value>text</value>
      <object>
         <subfield1>false</subfield1>
         <subfield2>4</subfield2>
      </object>
   </items>
</doc>
```

## Build

Build it with sbt like this:

```
> sbt assembly
```

## Run

Run it like this:

```
java -jar target/pincette-jsontoxml-assembly-<version>.jar < t.json > t.xml
```


