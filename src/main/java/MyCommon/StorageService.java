/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyCommon;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public interface StorageService {

   void init();

   void store(MultipartFile file);

   Stream<Path> loadAll();

   Path load(String filename);

   Resource loadAsResource(String filename);

   void deleteAll();

}
