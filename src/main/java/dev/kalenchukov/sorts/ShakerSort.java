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

import org.jetbrains.annotations.NotNull;

import java.util.*;

/**
 * Класс реализации сортировщика объектов с помощью алгоритма шейкерной сортировки.
 *
 * @param <T> тип сортируемых объектов.
 * @author Алексей Каленчуков
 */
public class ShakerSort<T> extends AbstractSort<T>
{
	/**
	 * Конструктор для {@code ShakerSort}.
	 *
	 * @param elements коллекция сортируемых элементов.
	 * @param comparator компаратор.
	 * @throws NullPointerException если в качестве коллекции элементов или компаратора передан {@code null}.
	 */
	public ShakerSort(@NotNull final List<T> elements, @NotNull final Comparator<T> comparator)
	{
		super(elements, comparator);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param elements {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NullPointerException если в качестве коллекции элементов передан {@code null}.
	 */
	@NotNull
	@Override
	protected List<T> sortElements(@NotNull final List<T> elements)
	{
		Objects.requireNonNull(elements);

		if (elements.size() < 2) {
			return elements;
		}

		List<T> sortedElements = new ArrayList<>(elements);

		for (int i = 0; i < (elements.size() / 2); i++)
		{
			for (int current = i; current < ((elements.size() - 1) - i); current++)
			{
				final int comparisonResult = this.getComparator().compare(
					sortedElements.get(current),
					sortedElements.get(current + 1)
				);

				if (comparisonResult > 0) {
					Collections.swap(sortedElements, current, current + 1);
				}
			}

			for (int current = ((elements.size() - 1) - i); current > i; current--)
			{
				final int comparisonResult = this.getComparator().compare(
					sortedElements.get(current),
					sortedElements.get(current - 1)
				);

				if (comparisonResult < 0) {
					Collections.swap(sortedElements, current, current - 1);
				}
			}
		}

		return sortedElements;
	}
}
