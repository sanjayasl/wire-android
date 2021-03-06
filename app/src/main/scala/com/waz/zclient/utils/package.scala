/**
 * Wire
 * Copyright (C) 2016 Wire Swiss GmbH
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.waz.zclient

import android.view.View
import android.view.View._

package object utils {

  implicit class RichView(val view: View) extends AnyVal {
    def setVisible(isVisible: Boolean): Unit = {
      view.setVisibility(if (isVisible) VISIBLE else GONE)
    }

    //TODO improve this so that multiple click listeners can be set from different places at once
    //TODO could also handle a set of views?
    def onClick(f: => Unit): Unit = {
      view.setOnClickListener(new OnClickListener {
        override def onClick(v: View): Unit = f
      })
    }
  }
}
