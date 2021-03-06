package metaprogramming

import java.text.NumberFormat;

Number.metaClass.asCurrency = { ->
    NumberFormat nf = NumberFormat.currencyInstance
    nf.format(delegate)
} 

Number.metaClass.asCurrency = { Locale loc ->
    NumberFormat nf = NumberFormat.getCurrencyInstance(loc)
    nf.format(delegate)
}


def amount = 123456.7890
Locale.default = Locale.US
assert amount.asCurrency() == '$123,456.79'
// assert amount.asCurrency(Locale.FRANCE) == "123 456,79 \u20AC"
println amount.asCurrency(Locale.FRANCE)