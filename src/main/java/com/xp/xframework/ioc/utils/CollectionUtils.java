package com.xp.xframework.ioc.utils;

import java.util.Collection;

public class CollectionUtils {
	
	//@Nullable Collection<?> collection
	public static boolean isEmpty(Collection<?> collection) {
		return (collection == null || collection.isEmpty());
	}
}
