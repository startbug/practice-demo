package com.ggs.event.service.impl;

import com.ggs.event.entity.File;
import com.ggs.event.mapper.FileMapper;
import com.ggs.event.service.IFileService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author lhh
 * @since 2024-04-17
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements IFileService {

}
