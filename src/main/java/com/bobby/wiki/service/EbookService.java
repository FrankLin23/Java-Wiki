package com.bobby.wiki.service;

import com.bobby.wiki.domain.Ebook;
import com.bobby.wiki.domain.EbookExample;
import com.bobby.wiki.mapper.EbookMapper;
import com.bobby.wiki.req.EbookReq;
import com.bobby.wiki.resp.EbookResp;
import com.bobby.wiki.utils.CopyUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EbookService {

    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();
        EbookExample.Criteria criteria = ebookExample.createCriteria();
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);

        List<EbookResp> respList = CopyUtil.copyList(ebookList, EbookResp.class);
        return respList;
    }

}
