## Jongo Query
Module to simplify the generation of Jongo queries programmatically. The module supports arrays and objects that contain JSON templates. It keeps track of both the JSON template and the parameters necessary to build it.

Below are some examples of how it can be used.

### Object example
Let's transform the following code:
```java
if(name != null) {
  collection.find("{age: {$gt: #}, name: #}", 21, name);
} else {
  collection.find("{age: {$gt: #}}", 21);
}
```
Using the jongo-query module, you can rewrite this as:
```java
ObjectCriteria query = new ObjectCriteria();
query.add("age: {$gt: #}", 21);
if(name != null){
  query.add("name: #", name);
}
collection.find(query.getQuery(), query.getParameters());

```

### Array example
It is difficult to generate a query from a list of values in jongo. The ArrayCriteria class addresses that issue.
```java
List<Person> persons = ...;
ArrayCriteria query = new ArrayCriteria();
for(Person person: people){
  query.add("{age: {$gt: #}, name: #}", person.getAge(), person.getName());
}
collection.find(String.format("{$or: %s}", query.getQuery()), query.getParameters());
```
It would generate a query that looks like `{$or: [{age: {$gt: #}, name: #}, {age: {$gt: #}, name: #} ...]}` with the appropriate number of parameters.
