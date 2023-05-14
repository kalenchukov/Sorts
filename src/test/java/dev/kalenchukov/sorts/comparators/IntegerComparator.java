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

package dev.kalenchukov.sorts.comparators;

import java.util.Comparator;

/**
 * Класс компаратора для объектов типа {@code Integer}.
 *
 * @author Алексей Каленчуков
 */
public class IntegerComparator implements Comparator<Integer>
{
	/**
	 * Сравнивает два объекта.
	 *
	 * @param value1 первый объект для сравнения
	 * @param value2 второй объект для сравнения
	 * @return возвращает:
	 * <ul>
	 *     <li>-1 - если первый объект меньше второго</li>
	 *     <li>0 - если первый объект равен второму</li>
	 *     <li>1 - если первый объект больше второго</li>
	 * </ul>
	 */
	@Override
	public int compare(final Integer value1, final Integer value2)
	{
		return value1.compareTo(value2);
	}
}
