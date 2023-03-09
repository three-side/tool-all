package com.threesides.collection;

import com.sun.istack.internal.Nullable;

import java.util.Collection;
import java.util.Map;

/**
 * CollectionUtil
 *
 * @author Di Wu
 * @since 2023-02-27
 */
public class CollectionUtil {

	public static boolean isEmpty(final Collection<?> coll) {
		return coll == null || coll.isEmpty();
	}


	public static boolean isNotEmpty(final Collection<?> coll) {
		return !isEmpty(coll);
	}

	public static boolean isEmpty(@Nullable Map<?, ?> map) {
		return (map == null || map.isEmpty());
	}

	public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
		return !isEmpty(map);
	}



}
