import { TestBed } from '@angular/core/testing';

import { MaterialsReceivedNoteService } from './materials-received-note.service';

describe('MaterialsReceivedNoteService', () => {
  let service: MaterialsReceivedNoteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MaterialsReceivedNoteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
