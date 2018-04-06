/*
 * Copyright 1999-2004 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package javax.imageio;

/**
 * An abstract superclass for parsing and decoding of images.  This
 * class must be subclassed by classes that read in images in the
 * context of the Java Image I/O framework.
 *
 * <p> <code>ImageReader</code> objects are normally instantiated by
 * the service provider interface (SPI) class for the specific format.
 * Service provider classes (e.g., instances of
 * <code>ImageReaderSpi</code>) are registered with the
 * <code>IIORegistry</code>, which uses them for format recognition
 * and presentation of available format readers and writers.
 *
 * <p> When an input source is set (using the <code>setInput</code>
 * method), it may be marked as "seek forward only".  This setting
 * means that images contained within the input source will only be
 * read in order, possibly allowing the reader to avoid caching
 * portions of the input containing data associated with images that
 * have been read previously.
 *
 * @see ImageWriter
 * @see javax.imageio.spi.IIORegistry
 * @see javax.imageio.spi.ImageReaderSpi
 *
 */
public abstract class ImageReader {
}