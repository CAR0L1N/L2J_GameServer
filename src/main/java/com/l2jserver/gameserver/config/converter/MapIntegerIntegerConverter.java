/*
 * Copyright © 2019 L2J Server
 *
 * This file is part of L2J Server.
 *
 * L2J Server is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * L2J Server is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program. If not, see <http://www.gnu.org/licenses/>.
 */
package com.l2jserver.gameserver.config.converter;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.aeonbits.owner.Converter;
import org.apache.logging.log4j.util.Strings;

/**
 * Map Integer-Integer Converter.
 * @author Zoey76
 * @version 2.6.1.0
 */
public class MapIntegerIntegerConverter implements Converter<Map<Integer, Integer>> {
	
	@Override
	public Map<Integer, Integer> convert(Method method, String input) {
		final var map = new HashMap<Integer, Integer>();
		if (Strings.isBlank(input)) {
			return map;
		}
		
		final var tokens = input.replaceAll(" ", "").split(";");
		for (var token : tokens) {
			final var splitToken = token.split(",");
			map.put(Integer.valueOf(splitToken[0]), Integer.valueOf(splitToken[1]));
		}
		return map;
	}
}
