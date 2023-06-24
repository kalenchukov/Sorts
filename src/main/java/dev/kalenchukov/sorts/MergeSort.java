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
 * Класс реализации сортировщика объектов с помощью алгоритма сортировки слиянием.
 *
 * @param <T> тип сортируемых объектов.
 * @author Алексей Каленчуков
 */
public class MergeSort<T> extends AbstractSort<T>
{
	/**
	 * Конструктор для {@code MergeSort}.
	 *
	 * @param elements коллекция сортируемых элементов.
	 * @param comparator компаратор.
	 * @throws NullPointerException если в качестве {@code elements} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code comparator} передан {@code null}.
	 */
	public MergeSort(@NotNull final List<T> elements, @NotNull final Comparator<T> comparator)
	{
		super(elements, comparator);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param elements {@inheritDoc}
	 * @return {@inheritDoc}
	 * @throws NullPointerException если в качестве {@code elements} передан {@code null}.
	 */
	@NotNull
	@Override
	protected List<T> sortElements(@NotNull final List<T> elements)
	{
		Objects.requireNonNull(elements);

		if (elements.size() < 2) {
			return elements;
		}

		final int middle = elements.size() / 2;

		List<T> leftPart = new ArrayList<>(elements.subList(0, middle));
		List<T> rightPart = new ArrayList<>(elements.subList(middle, elements.size()));

		leftPart = this.sortElements(leftPart);
		rightPart = this.sortElements(rightPart);

		return this.mergeParts(leftPart, rightPart);
	}

	/**
	 * Объединяет коллекции с отсортированными объектами.
	 *
	 * @param leftPart первая коллекция элементов.
	 * @param rightPart вторая коллекция элементов.
	 * @return коллекцию с отсортированными объектами.
	 * @throws NullPointerException если в качестве {@code leftPart} передан {@code null}.
	 * @throws NullPointerException если в качестве {@code rightPart} передан {@code null}.
	 */
	@NotNull
	private List<T> mergeParts(@NotNull final List<T> leftPart, @NotNull final List<T> rightPart)
	{
		Objects.requireNonNull(leftPart);
		Objects.requireNonNull(rightPart);

		final List<T> sortedElements = new ArrayList<>();
		int indexLeft = 0;
		int indexRight = 0;

		while (leftPart.size() != indexLeft && rightPart.size() != indexRight)
		{
			final int comparisonResult = this.getComparator().compare(
				leftPart.get(indexLeft),
				rightPart.get(indexRight)
			);

			if (comparisonResult < 0) {
				sortedElements.add(leftPart.get(indexLeft));
				indexLeft++;
			} else {
				sortedElements.add(rightPart.get(indexRight));
				indexRight++;
			}
		}

		while (leftPart.size() != indexLeft)
		{
			sortedElements.add(leftPart.get(indexLeft));
			indexLeft++;
		}

		while (rightPart.size() != indexRight)
		{
			sortedElements.add(rightPart.get(indexRight));
			indexRight++;
		}

		return sortedElements;
	}
}
