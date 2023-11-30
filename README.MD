# Справка
## Sorts
Коллекция алгоритмов сортировки.

## Реализованные алгоритмы сортировки
* Сортировка слиянием
* Сортировка пузырьком
* Шейкерная сортировка
* Сортировка расчёской
* Сортировка вставками
* Сортировка выбором

## Использование
Для сортировки элементов разных типов требуется использовать компараторы.

### Компаратор
#### Пример реализации компаратора для объектов типа Integer.
```java
import java.lang.Integer;
import java.util.Comparator;

public class IntegerComparator implements Comparator<Integer>
{
	@Override
	public int compare(final Integer value1, final Integer value2)
	{
		return value1.compareTo(value2);
	}
}
```

#### Пример реализации компаратора для объектов типа String.
```java
import java.lang.String;
import java.util.Comparator;

public class StringComparator implements Comparator<String>
{
	@Override
	public int compare(final String value1, final String value2)
	{
		if (value1.length() < value2.length()) {
			return -1;
		} else if (value1.length() > value2.length())  {
			return 1;
		}

		return 0;
	}
}
```

### Сортировка
#### Сортировка слиянием
```java
import java.lang.Integer;
import java.util.List;
import dev.kalenchukov.sorts.Sorting;
import dev.kalenchukov.sorts.MergeSort;

List<Integer> elements = List.of(
	6, 9, 8, 1, 7, -5, 3, 4, 5, 0, 20, 77, -0, -100, 78, 69
);

Sorting<Integer> sorting = new MergeSort<>(elements, new IntegerComparator());
List<Integer> sortedElements = sorting.sort();
```

Результат выполнения:
```
-100, -5, 0, 0, 1, 3, 4, 5, 6, 7, 8, 9, 20, 69, 77, 78
```

#### Сортировка пузырьком
```java
import java.lang.Integer;
import java.util.List;
import dev.kalenchukov.sorts.Sorting;
import dev.kalenchukov.sorts.BubbleSort;

List<Integer> elements = List.of(
	90, 7, 0, 8, 0, 6, -1
);

Sorting<Integer> sorting = new BubbleSort<>(elements, new IntegerComparator());
List<Integer> sortedElements = sorting.sort();
```

Результат выполнения:
```
-1, 0, 0, 6, 7, 8, 90
```

#### Шейкерная сортировка
```java
import java.lang.Integer;
import java.util.List;
import dev.kalenchukov.sorts.Sorting;
import dev.kalenchukov.sorts.ShakerSort;

List<Integer> elements = List.of(
	110, 5, 1, 97, 0, 7, 5, -0, 4, -4, -9
);

Sorting<Integer> sorting = new ShakerSort<>(elements, new IntegerComparator());
List<Integer> sortedElements = sorting.sort();
```

Результат выполнения:
```
-9, -4, 0, 0, 1, 4, 5, 5, 7, 97, 110
```

#### Сортировка расчёской
```java
import java.lang.Integer;
import java.util.List;
import dev.kalenchukov.sorts.Sorting;
import dev.kalenchukov.sorts.CombSort;

List<Integer> elements = List.of(
	11, 4, 8, -12, 6, 3, 9, -5, 1, 2, 13, 7, 10
);

Sorting<Integer> sorting = new CombSort<>(elements, new IntegerComparator());
List<Integer> sortedElements = sorting.sort();
```

Результат выполнения:
```
-12, -5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13
```

#### Сортировка вставками
```java
import java.lang.Integer;
import java.util.List;
import dev.kalenchukov.sorts.Sorting;
import dev.kalenchukov.sorts.InsertionSort;

List<Integer> elements = List.of(
	999, 0, -9, 94, -12, 47, 300, 86, 86, -1000
);

Sorting<Integer> sorting = new InsertionSort<>(elements, new IntegerComparator());
List<Integer> sortedElements = sorting.sort();
```

Результат выполнения:
```
-1000, -12, -9, 0, 47, 86, 86, 94, 300, 999
```

#### Сортировка выбором
```java
import java.lang.Integer;
import java.util.List;
import dev.kalenchukov.sorts.Sorting;
import dev.kalenchukov.sorts.SelectionSort;

List<Integer> elements = List.of(
	889, 7, 1, 6, 1, -7, 56, 47, 0, -700
);

Sorting<Integer> sorting = new SelectionSort<>(elements, new IntegerComparator());
List<Integer> sortedElements = sorting.sort();
```

Результат выполнения:
```
-700, -7, 0, 1, 1, 6, 7, 47, 56, 889
```