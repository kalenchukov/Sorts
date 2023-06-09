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

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link SelectionSort}.
 *
 * @author Алексей Каленчуков
 */
public class SelectionSortTest
{
	/**
	 * Проверка метода {@link SelectionSort#sort()}.
	 */
	@Test
	public void sort()
	{
		List<Integer> value = List.of(889, 7, 1, 6, 1, -7, 56, 47, 0, -700);
		List<Integer> expectedList = List.of(-700, -7, 0, 1, 1, 6, 7, 47, 56, 889);

		Sorting<Integer> sort = new SelectionSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}

	/**
	 * Проверка метода {@link SelectionSort#sort()} без элементов.
	 */
	@Test
	public void sortNotElement()
	{
		List<Integer> value = Collections.emptyList();
		List<Integer> expectedList = Collections.emptyList();

		Sorting<Integer> sort = new SelectionSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}

	/**
	 * Проверка метода {@link SelectionSort#sort()} с одним элементом.
	 */
	@Test
	public void sortOneElement()
	{
		List<Integer> value = List.of(85);
		List<Integer> expectedList = List.of(85);

		Sorting<Integer> sort = new SelectionSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}

	/**
	 * Проверка метода {@link SelectionSort#sort()} с двумя элементами.
	 */
	@Test
	public void sortTwoElement()
	{
		List<Integer> value = List.of(85, 10);
		List<Integer> expectedList = List.of(10, 85);

		Sorting<Integer> sort = new SelectionSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}
}