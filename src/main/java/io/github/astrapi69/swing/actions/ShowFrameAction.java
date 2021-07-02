/**
 * The MIT License
 *
 * Copyright (C) 2021 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package io.github.astrapi69.swing.actions;

import java.awt.event.ActionEvent;

import javax.swing.*;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

/**
 * The abstract class {@link ShowFrameAction}
 */
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public abstract class ShowFrameAction extends AbstractAction
{

	private static final long serialVersionUID = 1L;

	/** The title of the frame */
	String title;

	/**
	 * Instantiates a new {@link ShowFrameAction} object
	 *
	 * @param name
	 *            the name
	 */
	public ShowFrameAction(final @NonNull String name)
	{
		this(name, name);
	}

	/**
	 * Instantiates a new {@link ShowFrameAction} object
	 *
	 * @param name
	 *            the name
	 * @param title
	 *            the title
	 */
	public ShowFrameAction(final String name, final @NonNull String title)
	{
		super(name);
		this.title = title;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void actionPerformed(final ActionEvent e)
	{
		onShowFrame(e);
	}

	/**
	 * Abstract callback method to interact when the Frame will show
	 *
	 * @param e
	 *            the action event
	 */
	protected abstract void onShowFrame(final ActionEvent e);

}
