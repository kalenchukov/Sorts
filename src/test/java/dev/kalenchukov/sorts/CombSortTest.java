/*
 * Copyright © 2023 Алексей Каленчуков
 * GitHub: https://github.com/kalenchukov
 * E-mail: mailto:aleksey.kalenchukov@yandex.ru
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package dev.kalenchukov.sorts;

import dev.kalenchukov.sorts.comparators.IntegerComparator;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link CombSort}.
 *
 * @author Алексей Каленчуков
 */
public class CombSortTest
{
	/**
	 * Проверка метода {@link CombSort#sort()}.
	 */
	@Test
	public void sort()
	{
		List<Integer> value = List.of(11, 4, 8, -12, 6, 3, 9, -5, 1, 2, 13, 7, 10);
		List<Integer> expectedList = List.of(-12, -5, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13);

		Sorting<Integer> sort = new CombSort<>(value, new IntegerComparator());
		List<Integer> actualList = sort.sort();

		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	/**
	 * Проверка метода {@link CombSort#sort()} без элементов.
	 */
	@Test
	public void sortNotElement()
	{
		List<Integer> value = Collections.emptyList();
		List<Integer> expectedList = Collections.emptyList();

		Sorting<Integer> sort = new CombSort<>(value, new IntegerComparator());
		List<Integer> actualList = sort.sort();

		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	/**
	 * Проверка метода {@link CombSort#sort()} с одним элементом.
	 */
	@Test
	public void sortOneElement()
	{
		List<Integer> value = List.of(89);
		List<Integer> expectedList = List.of(89);

		Sorting<Integer> sort = new CombSort<>(value, new IntegerComparator());
		List<Integer> actualList = sort.sort();

		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}

	/**
	 * Проверка метода {@link CombSort#sort()} с двумя элементами.
	 */
	@Test
	public void sortTwoElement()
	{
		List<Integer> value = List.of(89, 71);
		List<Integer> expectedList = List.of(71, 89);

		Sorting<Integer> sort = new CombSort<>(value, new IntegerComparator());
		List<Integer> actualList = sort.sort();

		assertArrayEquals(expectedList.toArray(), actualList.toArray());
	}
}