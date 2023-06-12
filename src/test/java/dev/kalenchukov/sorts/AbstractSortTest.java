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

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Класс проверки методов класса {@link AbstractSort}.
 *
 * @author Алексей Каленчуков
 */
public class AbstractSortTest
{
	/**
	 * Проверка метода {@link AbstractSort#getTimeStart()}.
	 */
	@Test
	public void getTimeStart()
	{
		List<Integer> value = List.of(78, 6, 1, 7, -5, 3, 5, 0, 20, 77, -0, 69, -100);

		Sorting<Integer> sort = new MergeSort<>(value, new IntegerComparator());
		sort.sort();
		Long actualTimeStart = sort.getTimeStart();

		assertThat(actualTimeStart).isNotNull();
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeStart()} без выполнения сортировки.
	 */
	@Test
	public void getTimeStartNull()
	{
		List<Integer> value = List.of(78, 6, 1, 7, -5, 3, 5, 0, 20, 77, -0, 69, -100);

		Sorting<Integer> sort = new MergeSort<>(value, new IntegerComparator());
		Long actualTimeStart = sort.getTimeStart();

		assertThat(actualTimeStart).isNull();
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeEnd()}.
	 */
	@Test
	public void getTimeEnd()
	{
		List<Integer> value = List.of(78, 6, 1, 7, -5, 3, 5, 0, 20, 77, -0, 69, -100);

		Sorting<Integer> sort = new MergeSort<>(value, new IntegerComparator());
		sort.sort();
		Long actualTimeEnd = sort.getTimeEnd();

		assertThat(actualTimeEnd).isNotNull();
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeEnd()} без выполнения сортировки.
	 */
	@Test
	public void getTimeEndNull()
	{
		List<Integer> value = List.of(78, 6, 1, 7, -5, 3, 5, 0, 20, 77, -0, 69, -100);

		Sorting<Integer> sort = new MergeSort<>(value, new IntegerComparator());
		Long actualTimeEnd = sort.getTimeEnd();

		assertThat(actualTimeEnd).isNull();
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeSpent()}.
	 */
	@Test
	public void getTimeSpent()
	{
		List<Integer> value = List.of(78, 6, 1, 7, -5, 3, 5, 0, 20, 77, -0, 69, -100);

		Sorting<Integer> sort = new MergeSort<>(value, new IntegerComparator());
		sort.sort();
		Long actualTimeSpent = sort.getTimeSpent();

		assertThat(actualTimeSpent).isNotNull();
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeStart()} без выполнения сортировки.
	 */
	@Test
	public void getTimeSpentNull()
	{
		List<Integer> value = List.of(78, 6, 1, 7, -5, 3, 5, 0, 20, 77, -0, 69, -100);

		Sorting<Integer> sort = new MergeSort<>(value, new IntegerComparator());
		Long actualTimeSpent = sort.getTimeSpent();

		assertThat(actualTimeSpent).isNull();
	}
}