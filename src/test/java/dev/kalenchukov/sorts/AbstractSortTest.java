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

import static org.junit.jupiter.api.Assertions.*;

/**
 * Класс проверки методов класса {@link AbstractSort}.
 *
 * @author Aleksey Kalenchukov
 */
public class AbstractSortTest
{
	private final List<Integer> elements = List.of(
		78, 6, 9, 8, 1, 7, -5, 3, 4, 5, 0, 20, 77, -0, 69, -100
	);

	/**
	 * Проверка метода {@link AbstractSort#getTimeStart()}.
	 */
	@Test
	public void testGetTimeStart()
	{
		Sorting<Integer> sorting = new MergeSort<>(this.elements, new IntegerComparator());
		sorting.sort();
		Long time = sorting.getTimeStart();

		assertNotNull(time);
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeStart()} без начала сортировки.
	 */
	@Test
	public void testGetTimeStartNull()
	{
		Sorting<Integer> sorting = new MergeSort<>(this.elements, new IntegerComparator());
		Long time = sorting.getTimeStart();

		assertNull(time);
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeEnd()}.
	 */
	@Test
	public void testGetTimeEnd()
	{
		Sorting<Integer> sorting = new MergeSort<>(this.elements, new IntegerComparator());
		sorting.sort();
		Long time = sorting.getTimeEnd();

		assertNotNull(time);
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeEnd()} без начала сортировки.
	 */
	@Test
	public void testGetTimeEndNull()
	{
		Sorting<Integer> sorting = new MergeSort<>(this.elements, new IntegerComparator());
		Long time = sorting.getTimeEnd();

		assertNull(time);
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeSpent()}.
	 */
	@Test
	public void testGetTimeSpent()
	{
		Sorting<Integer> sorting = new MergeSort<>(this.elements, new IntegerComparator());
		sorting.sort();
		Long time = sorting.getTimeSpent();

		assertNotNull(time);
	}

	/**
	 * Проверка метода {@link AbstractSort#getTimeStart()} без начала сортировки.
	 */
	@Test
	public void testGetTimeSpentNull()
	{
		Sorting<Integer> sorting = new MergeSort<>(this.elements, new IntegerComparator());
		Long time = sorting.getTimeSpent();

		assertNull(time);
	}
}