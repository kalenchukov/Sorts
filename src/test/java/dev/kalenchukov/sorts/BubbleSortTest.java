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
 * Класс проверки методов класса {@link BubbleSort}.
 *
 * @author Алексей Каленчуков
 */
public class BubbleSortTest
{
	/**
	 * Проверка метода {@link BubbleSort#sort()}.
	 */
	@Test
	public void sort()
	{
		List<Integer> value = List.of(90, 7, 0, 8, 0, 6, -1);
		List<Integer> expectedList = List.of(-1, 0, 0, 6, 7, 8, 90);

		Sorting<Integer> sort = new BubbleSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}

	/**
	 * Проверка метода {@link BubbleSort#sort()} без элементов.
	 */
	@Test
	public void sortNotElement()
	{
		List<Integer> value = Collections.emptyList();
		List<Integer> expectedList = Collections.emptyList();

		Sorting<Integer> sort = new BubbleSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}

	/**
	 * Проверка метода {@link BubbleSort#sort()} с одним элементом.
	 */
	@Test
	public void sortOneElement()
	{
		List<Integer> value = List.of(89);
		List<Integer> expectedList = List.of(89);

		Sorting<Integer> sort = new BubbleSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}

	/**
	 * Проверка метода {@link BubbleSort#sort()} с двумя элементами.
	 */
	@Test
	public void sortTwoElement()
	{
		List<Integer> value = List.of(89, 71);
		List<Integer> expectedList = List.of(71, 89);

		Sorting<Integer> sort = new BubbleSort<>(value, Integer::compareTo);
		List<Integer> actualList = sort.sort();

		assertThat(actualList).containsSequence(expectedList);
	}
}