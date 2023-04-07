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
import org.jetbrains.annotations.Range;

import java.util.*;

/**
 * Класс реализации сортировщика объектов с помощью алгоритма сортировки выбором.
 *
 * @param <T> тип сортируемых объектов.
 */
public class SelectionSort<T> extends AbstractSort<T>
{
	/**
	 * Конструктор для {@code SelectionSort}.
	 *
	 * @param elements коллекция сортируемых объектов.
	 * @param comparator компаратор.
	 * @throws NullPointerException если в качестве коллекции объектов или компаратора передан {@code null}.
	 */
	public SelectionSort(@NotNull final List<T> elements, @NotNull final Comparator<T> comparator)
	{
		super(elements, comparator);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param elements {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NullPointerException если в качестве коллекции объектов передан {@code null}.
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

		for (int index = 0; index < sortedElements.size(); index++)
		{
			final int indexMinElement = this.getIndexMinElement(sortedElements, index);

			if (indexMinElement != index) {
				Collections.swap(sortedElements, index, indexMinElement);
			}
		}

		return sortedElements;
	}

	/**
	 * Возвращает индекс минимального элемента.
	 *
	 * @param elements коллекция элементов.
	 * @param indexFrom минимальный индекс элемента с которого начинается поиск.
	 * @return возвращает индекс минимального элемента.
	 * @throws IllegalArgumentException если в коллекции нет элементов.
	 * @throws IllegalArgumentException если индекс элемента с которого начинается поиск, меньше нуля или превышает количество элементов.
	 */
	@NotNull
	private Integer getIndexMinElement(@NotNull final List<T> elements,
									   @NotNull @Range(from = 0, to = Integer.MAX_VALUE) final Integer indexFrom)
	{
		Objects.requireNonNull(elements);

		if (elements.isEmpty()) {
			throw new IllegalArgumentException();
		}

		if (indexFrom < 0 || indexFrom > elements.size()) {
			throw new IllegalArgumentException();
		}

		int indexMinElement = indexFrom;

		for (int index = indexFrom; index < elements.size(); index++)
		{
			final int comparisonResult = this.getComparator().compare(
				elements.get(index),
				elements.get(indexMinElement)
			);

			if (comparisonResult < 0) {
				indexMinElement = index;
			}
		}

		return indexMinElement;
	}
}
