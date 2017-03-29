package com.ngtesting.platform.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Service;

import com.ngtesting.platform.entity.EvtDocument;
import com.ngtesting.platform.entity.EvtGuest;
import com.ngtesting.platform.entity.EvtDocument.DocType;
import com.ngtesting.platform.service.DocumentService;
import com.ngtesting.platform.util.BeanUtilEx;
import com.ngtesting.platform.vo.DocumentVo;
import com.ngtesting.platform.vo.GuestVo;
import com.ngtesting.platform.vo.Page;

@Service
public class DocumentServiceImpl extends BaseServiceImpl implements DocumentService {

    @Override
    public List<EvtDocument> listByEvent(Long eventId, DocType type) {
        DetachedCriteria dc = DetachedCriteria.forClass(EvtDocument.class);
        dc.add(Restrictions.eq("eventId", eventId));
        
        if (type != null) {
        	dc.add(Restrictions.eq("docType", type));
        }
        
        dc.add(Restrictions.eq("deleted", Boolean.FALSE));
        dc.add(Restrictions.eq("disabled", Boolean.FALSE));
        dc.addOrder(Order.asc("id"));
        List<EvtDocument> docPos = findAllByCriteria(dc);
        
        return docPos;
    }
    
	@Override
	public Page listByPage(long eventId, int currentPage, int itemsPerPage, DocType type) {
        DetachedCriteria dc = DetachedCriteria.forClass(EvtDocument.class);
        dc.add(Restrictions.eq("eventId", eventId));
        
        if (type != null) {
        	dc.add(Restrictions.eq("docType", type));
        }
        
        dc.add(Restrictions.eq("deleted", Boolean.FALSE));
        dc.add(Restrictions.eq("disabled", Boolean.FALSE));
        dc.addOrder(Order.asc("id"));
        Page page = findPage(dc, currentPage * itemsPerPage, itemsPerPage);
        
        return page;
	}
	
	@Override
	public EvtDocument save(DocumentVo vo) {
		if (vo == null) {
			return null;
		}
		
		EvtDocument po = new EvtDocument();
		if (vo.getId() != null) {
			po = (EvtDocument) get(EvtDocument.class, vo.getId());
		}
		
		po.setEventId(vo.getEventId());
		po.setTitle(vo.getTitle());
		po.setUri(vo.getUri());
		
		saveOrUpdate(po);
		return po;
	}
	
	@Override
	public boolean remove(Long id) {
		EvtDocument po = (EvtDocument) get(EvtDocument.class, id);
		po.setDeleted(true);
		saveOrUpdate(po);
		
		return true;
	}

	@Override
	public List<DocumentVo> genVos(List<EvtDocument> pos) {
        List<DocumentVo> vos = new LinkedList<DocumentVo>();
        for (EvtDocument po: pos) {
        	DocumentVo vo = genVo(po);
        	vos.add(vo);
        }
		return vos;
	}
	@Override
	public DocumentVo genVo(EvtDocument po) {

    	DocumentVo vo = new DocumentVo();
    	BeanUtilEx.copyProperties(vo, po);

		return vo;
	}
    
}
