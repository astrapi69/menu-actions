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
package io.github.astrapi69.swing.menu;

import java.awt.Component;
import java.awt.Event;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

import lombok.NonNull;
import io.github.astrapi69.swing.menu.builder.JMenuItemInfo;
import io.github.astrapi69.swing.menu.popup.listener.PopupListener;

/**
 * A factory {@link MenuFactory} provides factory methods for create Menu and JToolbar objects
 */
public class MenuFactory
{

	/**
	 * Factory method for create a {@link JMenuBar} object
	 *
	 * @return the {@link JMenuBar} object
	 */
	public static JMenuBar newJMenuBar()
	{
		return new JMenuBar();
	}

	/**
	 * Factory method for create a {@link JToolBar} object
	 *
	 * @return the {@link JToolBar} object
	 */
	public static JToolBar newJToolBar()
	{
		return new JToolBar();
	}

	/**
	 * Factory method for create a <code>JMenu</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenu</code>
	 * @return the new {@link JMenu} object
	 */
	public static JMenu newJMenu(final @NonNull String text)
	{
		return JMenuItemInfo.builder().text(text).build().toJMenu();
	}

	/**
	 * Factory method for create a <code>JMenu</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenu</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenu</code>
	 * @return the new {@link JMenu} object
	 */
	public static JMenu newJMenu(final @NonNull String text, final int mnemonic)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic).build().toJMenu();
	}

	/**
	 * Factory method for create a <code>JMenu</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenu</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenu</code>
	 * @param actionListener
	 *            The action listener for the <code>JMenu</code>
	 * @return the new {@link JMenu} object
	 */
	public static JMenu newJMenu(final @NonNull String text, final int mnemonic,
		final @NonNull ActionListener actionListener)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic).actionListener(actionListener)
			.build().toJMenu();
	}

	/**
	 * Factory method for create a <code>JMenu</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenu</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenu</code>
	 * @return the new {@link JMenu} object
	 */
	public static JMenu newJMenu(final @NonNull String text, final char mnemonic)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(MenuExtensions.toMnemonic(mnemonic))
			.build().toJMenu();
	}

	/**
	 * Factory method for create a <code>JMenu</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenu</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenu</code>
	 * @param actionListener
	 *            The action listener for the <code>JMenu</code>
	 * @return the new {@link JMenu} object
	 */
	public static JMenu newJMenu(final @NonNull String text, final char mnemonic,
		final @NonNull ActionListener actionListener)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(MenuExtensions.toMnemonic(mnemonic))
			.actionListener(actionListener).build().toJMenu();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text)
	{
		return JMenuItemInfo.builder().text(text).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text,
		final @NonNull ActionListener actionListener)
	{
		return JMenuItemInfo.builder().text(text).actionListener(actionListener).build()
			.toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final int mnemonic)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final int mnemonic,
		final char accelerator)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic)
			.keyStroke(KeyStroke.getKeyStroke(accelerator, Event.CTRL_MASK)).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 * @param actionListener
	 *            The action listener for the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final int mnemonic,
		final char accelerator, final @NonNull ActionListener actionListener)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic)
			.keyStroke(KeyStroke.getKeyStroke(accelerator, Event.CTRL_MASK))
			.actionListener(actionListener).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param keyStroke
	 *            The keystroke
	 * @param actionListener
	 *            The action listener for the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final int mnemonic,
		final KeyStroke keyStroke, final @NonNull ActionListener actionListener)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic).keyStroke(keyStroke)
			.actionListener(actionListener).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param keyStroke
	 *            The keystroke
	 * @param actionListener
	 *            The action listener for the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final int mnemonic,
		final KeyStroke keyStroke, final ActionListener actionListener, String name)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(mnemonic).keyStroke(keyStroke)
			.actionListener(actionListener).name(name).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final char mnemonic,
		final char accelerator)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(MenuExtensions.toMnemonic(mnemonic))
			.keyStroke(KeyStroke.getKeyStroke(accelerator, Event.CTRL_MASK)).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JMenuItem</code>.
	 *
	 * @param text
	 *            the text of the <code>JMenuItem</code>
	 * @param mnemonic
	 *            the keyboard mnemonic for the <code>JMenuItem</code>
	 * @param accelerator
	 *            The character that have to push together with the CTRL.
	 * @param actionListener
	 *            The action listener for the <code>JMenuItem</code>
	 * @return the new {@link JMenuItem}
	 */
	public static JMenuItem newJMenuItem(final @NonNull String text, final char mnemonic,
		final char accelerator, final @NonNull ActionListener actionListener)
	{
		return JMenuItemInfo.builder().text(text).mnemonic(MenuExtensions.toMnemonic(mnemonic))
			.keyStroke(KeyStroke.getKeyStroke(accelerator, Event.CTRL_MASK))
			.actionListener(actionListener).build().toJMenuItem();
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code>.
	 *
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu()
	{
		return newJPopupMenu("");
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code> that will be add a
	 * <code>MouseListener</code> to the given <code>Component</code> and an array of
	 * <code>JMenuItem</code> that will be added to the popup.
	 *
	 * @param component
	 *            the component
	 * @param items
	 *            the <code>JMenuItem</code>s
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu(final Component component, final JMenuItem... items)
	{
		return newJPopupMenu("", component, items);
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code> with the specified title.
	 *
	 * @param label
	 *            the string that a UI may use to display as a title for the popup menu.
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu(final String label)
	{
		return new JPopupMenu(label);
	}

	/**
	 * Factory method for create a <code>JPopupMenu</code> that will be add a
	 * <code>MouseListener</code> to the given <code>Component</code> and an array of
	 * <code>JMenuItem</code> that will be added to the popup.
	 *
	 * @param label
	 *            the label
	 * @param component
	 *            the component
	 * @param items
	 *            the <code>JMenuItem</code>s
	 * @return the new {@link JPopupMenu}.
	 */
	public static JPopupMenu newJPopupMenu(final String label, final Component component,
		final JMenuItem... items)
	{
		// Create the popup menu.
		final JPopupMenu popup = newJPopupMenu(label);
		for (final JMenuItem jMenuItem : items)
		{
			popup.add(jMenuItem);
		}
		// Add listener to the component so the popup menu can come up.
		final MouseListener popupListener = new PopupListener(popup);
		component.addMouseListener(popupListener);
		return popup;
	}

	/**
	 * Factory method for create a {@link PopupMenu} object.
	 *
	 * @param menuItemBeans
	 *            the menu item beans
	 * @return the new {@link PopupMenu}.
	 */
	public static PopupMenu newPopupMenu(final List<MenuItemBean> menuItemBeans)
	{
		final PopupMenu popupMenu = new PopupMenu();
		for (final MenuItemBean menuItemBean : menuItemBeans)
		{
			final MenuItem miBringToFront = new MenuItem(menuItemBean.getLabel());
			miBringToFront.setActionCommand(menuItemBean.getCommand());
			miBringToFront.addActionListener(menuItemBean.getActionListener());
			popupMenu.add(miBringToFront);
		}
		return popupMenu;
	}

	/**
	 * Factory method for create a {@link TrayIcon} object.
	 *
	 * @param imgFilename
	 *            the img filename
	 * @param appName
	 *            the app name
	 * @param systemTrayPopupMenu
	 *            the system tray popup menu
	 * @param actionListeners
	 *            the action listeners
	 * @return the new {@link TrayIcon}.
	 */
	public static TrayIcon newTrayIcon(final String imgFilename, final String appName,
		final PopupMenu systemTrayPopupMenu, final Map<String, ActionListener> actionListeners)
	{
		final Image image = Toolkit.getDefaultToolkit().getImage(imgFilename);
		final TrayIcon trayIcon = new TrayIcon(image, appName, systemTrayPopupMenu);
		for (final Map.Entry<String, ActionListener> actionListener : actionListeners.entrySet())
		{
			trayIcon.setActionCommand(actionListener.getKey());
			trayIcon.addActionListener(actionListener.getValue());
		}
		return trayIcon;
	}
}
