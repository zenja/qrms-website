package com.qrms.service;

import java.util.List;
import com.qrms.bean.PuzzleSolvingGameInfo;

/**
 * Descroption:This class is for SeekGameService
 * 
 * @author Zhao Lu
 * @version 1.0
 */

public interface ISeekGameService {
	public List<PuzzleSolvingGameInfo> seekByCity(Object o);

	public List<PuzzleSolvingGameInfo> seekByProv(Object o);

	public List<PuzzleSolvingGameInfo> seekByCou(Object o);

	public List<PuzzleSolvingGameInfo> seekByOriginLatLong(Object lat,
			Object longt);

	public List<PuzzleSolvingGameInfo> seekByArea(double latitude,
			double longitude, double radius);
}
