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
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.Unmodifiable;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Класс абстрактной реализации сортировщика объектов.
 *
 * @param <T> тип сортируемых объектов.
 *
 * @author Aleksey Kalenchukov
 */
public abstract class AbstractSort<T> implements Sorting<T>
{
	/**
	 * Коллекция сортируемых объектов.
	 */
	@NotNull
	private final List<T> elements;

	/**
	 * Компаратор.
	 */
	@NotNull
	private final Comparator<T> comparator;

	/**
	 * Время начала сортировки в миллисекундах.
	 */
	@Nullable
	private Long timeStart;

	/**
	 * Время окончания сортировки в миллисекундах.
	 */
	@Nullable
	private Long timeEnd;

	/**
	 * Конструктор для {@code AbstractSort}.
	 *
	 * @param elements коллекция сортируемых объектов.
	 * @param comparator компаратор.
	 * @throws NullPointerException если в качестве коллекции объектов или компаратора передан {@code null}.
	 */
	protected AbstractSort(@NotNull final List<T> elements, @NotNull final Comparator<T> comparator)
	{
		Objects.requireNonNull(elements);
		Objects.requireNonNull(comparator);

		this.elements = elements;
		this.comparator = comparator;
		this.timeStart = null;
		this.timeEnd = null;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@NotNull
	@Unmodifiable
	@Override
	public final List<T> sort()
	{
		this.setTimeStart();
		List<T> sortedElements = this.sortElements(this.elements);
		this.setTimeEnd();

		return Collections.unmodifiableList(sortedElements);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Nullable
	public Long getTimeStart()
	{
		return this.timeStart;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Nullable
	public Long getTimeEnd()
	{
		return this.timeEnd;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return {@inheritDoc}
	 */
	@Nullable
	public Long getTimeSpent()
	{
		if (this.getTimeEnd() != null && this.getTimeStart() != null) {
			return (this.getTimeEnd() - this.getTimeStart());
		}

		return null;
	}
	/**
	 * Сортирует объекты коллекции.
	 *
	 * @param elements коллекция объектов для сортировки.
	 * @return коллекцию с отсортированными объектами.
	 */
	@NotNull
	protected abstract List<T> sortElements(@NotNull final List<T> elements);

	/**
	 * Возвращает компаратор.
	 *
	 * @return компаратор.
	 */
	@NotNull
	protected final Comparator<T> getComparator()
	{
		return this.comparator;
	}

	/**
	 * Устанавливает время начала сортировки.
	 */
	private void setTimeStart()
	{
		this.timeStart = System.currentTimeMillis();
	}

	/**
	 * Устанавливает время окончания сортировки.
	 */
	private void setTimeEnd()
	{
		this.timeEnd = System.currentTimeMillis();
	}
}
