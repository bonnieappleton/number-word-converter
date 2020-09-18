# Number-Word Converter

A Clojure library that can take a Java int in the range 0 to 999,999,999 inclusive and returns the equivalent number, 
as a String, in British English words.

## Requirements

- Java 8+
- Clojure
- Leiningen https://leiningen.org/

## Installation


## Usage


## Options


## Examples

| Input | Output |
|-------------|--------------|
| 0 | zero |
| 1 | one |
| 21 | twenty one |
| 105 | one hundred and five |
| 123 | one hundred and twenty three |
| 1005 | one thousand and five |
| 1042 | one thousand and forty two |
| 1105 | one thousand one hundred and five |
| 56945781 | fifty six million nine hundred and forty five thousand seven hundred and eighty one |
| 999999999 | nine hundred and ninety nine million nine hundred and ninety nine thousand nine hundred and ninety nine |

## Testing

To run full test suite use `lein test`

## License

Copyright © 2020 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
