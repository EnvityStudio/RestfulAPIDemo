package com.dao;

import java.util.List;

import com.entity.TVSeries;

public interface ITVSeriesDAO {
	List<TVSeries> searchTVSeries(String keyword);
}
