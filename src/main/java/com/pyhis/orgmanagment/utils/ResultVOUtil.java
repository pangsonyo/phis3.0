package com.pyhis.orgmanagment.utils;

import com.pyhis.orgmanagment.VO.ResultVO;

public class ResultVOUtil {

    //成功
    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(200);
        resultVO.setMsg("成功");
        return resultVO;
    }

//   private static ResultVO isEmpty(ResultVO resultVO){
//
//   }


}
